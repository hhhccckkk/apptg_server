package com.hck.apptg.phone.action;

import java.sql.Timestamp;

import com.hck.apptg.bean.Fankui;
import com.hck.apptg.daoserver.FanKuiServer;
import com.hck.apptg.daoserver.JinBiServer;

public class FanKuiAction extends BaseAction {
	private FanKuiServer mServer;
    private JinBiServer jinBiServer;
    
	public JinBiServer getJinBiServer() {
		return jinBiServer;
	}

	public void setJinBiServer(JinBiServer jinBiServer) {
		this.jinBiServer = jinBiServer;
	}

	public FanKuiServer getmServer() {
		return mServer;
	}

	public void setmServer(FanKuiServer mServer) {
		this.mServer = mServer;
	}

	public void addFanKui() {
		init();
		String titleString = getStringData("title");
		String content = getStringData("content");
		long uid = getLongData("id");
		Fankui fankui = new Fankui();
		fankui.setContent(content);
		fankui.setShijian(new Timestamp(System.currentTimeMillis()).toString());
		fankui.setTitle(titleString);
		fankui.setUid(uid);
		boolean isok = mServer.addFanKui(fankui);
		json.put("code", isok);
		boolean isok2 = jinBiServer.isAddJinBi(id, 50, 10);
		json.put("isok", isok2);
		write();
	}

}
