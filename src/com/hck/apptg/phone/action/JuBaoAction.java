package com.hck.apptg.phone.action;

import java.sql.Timestamp;

import com.hck.apptg.bean.Jubao;
import com.hck.apptg.daoserver.JuBaoServer;
import com.hck.apptg.vo.Contans;

public class JuBaoAction extends BaseAction {
	private JuBaoServer jServer;

	public JuBaoServer getjServer() {
		return jServer;
	}

	public void setjServer(JuBaoServer jServer) {
		this.jServer = jServer;
	}

	public void juBao() {
		init();
		long uid = getLongData("uid");
		long buid = getLongData("buid");
		String bContentString = getStringData("bcontent");
		String bname = getStringData("bname");
		Jubao jubao = new Jubao();
		jubao.setBcontent(bContentString);
		jubao.setBname(bname);
		jubao.setUid(uid);
		jubao.setBuid(buid);
		jubao.setBtime(new Timestamp(System.currentTimeMillis()).toString());
		if (jServer.addJuBao(jubao)) {
			json.put("code", true);
		} else {
			json.put("code", false);
		}
		write();
	}
}
