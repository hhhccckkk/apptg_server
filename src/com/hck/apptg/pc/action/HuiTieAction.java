package com.hck.apptg.pc.action;

import java.util.List;

import com.hck.apptg.bean.Huitie;
import com.hck.apptg.daoserver.HUiTieServer;
import com.opensymphony.xwork2.ActionContext;

public class HuiTieAction extends BaseAction {
	private HUiTieServer mHUiTieServer;
	private List<Huitie> huities;

	public List<Huitie> getHuities() {
		return huities;
	}

	public void setHuities(List<Huitie> huities) {
		this.huities = huities;
	}

	public HUiTieServer getmHUiTieServer() {
		return mHUiTieServer;
	}

	public void setmHUiTieServer(HUiTieServer mHUiTieServer) {
		this.mHUiTieServer = mHUiTieServer;
	}

	public String getHuiTie() {
		huities = mHUiTieServer.getHuities(page);
		ActionContext.getContext().getSession().put("huitiePage", page);
		return SUCCESS;
	}

	public String deleteHuiTie() {
		mHUiTieServer.deleteHuiTie(id);
		return SUCCESS;
	}

	public String getUserPl() {
		huities = mHUiTieServer.getUserHuiTie(page, id);
		ActionContext.getContext().getSession().put("huitiePage", page);
		return SUCCESS;
	}

}
