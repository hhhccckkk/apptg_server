package com.hck.apptg.pc.action;

import java.util.List;

import com.hck.apptg.bean.Jubao;
import com.hck.apptg.daoserver.JuBaoServer;
import com.opensymphony.xwork2.ActionContext;

public class JuBaoAction extends BaseAction {
	private List<Jubao> jubaos;
	private JuBaoServer mJuBaoServer;

	public List<Jubao> getJubaos() {
		return jubaos;
	}

	public void setJubaos(List<Jubao> jubaos) {
		this.jubaos = jubaos;
	}

	public JuBaoServer getmJuBaoServer() {
		return mJuBaoServer;
	}

	public void setmJuBaoServer(JuBaoServer mJuBaoServer) {
		this.mJuBaoServer = mJuBaoServer;
	}

	public String getJuBao() {
		jubaos = mJuBaoServer.getJuBao(page);
		ActionContext.getContext().getSession().put("jubaoPage", page);
		return SUCCESS;
	}

	public String deleteJuBao() {
		mJuBaoServer.deleteJuBao(id);
		return SUCCESS;
	}

}
