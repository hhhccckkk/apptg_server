package com.hck.apptg.pc.action;

import java.util.List;

import com.hck.apptg.bean.Fankui;
import com.hck.apptg.daoserver.FanKuiServer;

public class FanKuiAction extends BaseAction {
	private FanKuiServer mKuiServer;
	private List<Fankui> fankuis;

	public List<Fankui> getFankuis() {
		return fankuis;
	}

	public void setFankuis(List<Fankui> fankuis) {
		this.fankuis = fankuis;
	}

	public FanKuiServer getmKuiServer() {
		return mKuiServer;
	}

	public void setmKuiServer(FanKuiServer mKuiServer) {
		this.mKuiServer = mKuiServer;
	}

	public String getFanKui() {
		fankuis=mKuiServer.getFankuis();
		return SUCCESS;
	}
	
	public String deleteFanKui(){
		mKuiServer.deleteFanKui(id);
		return SUCCESS;
	}

}
