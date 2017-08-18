package com.hck.apptg.pc.action;

import java.util.Collections;
import java.util.List;

import com.hck.apptg.bean.Qudao;
import com.hck.apptg.daoserver.QuDaoServer;
import com.opensymphony.xwork2.ActionContext;

public class QuDaoAction extends BaseAction {
	private QuDaoServer quDaoServer;
	private List<Qudao> quLists;
    private int type;
    
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public QuDaoServer getQuDaoServer() {
		return quDaoServer;
	}

	public void setQuDaoServer(QuDaoServer quDaoServer) {
		this.quDaoServer = quDaoServer;
	}

	public List<Qudao> getQuLists() {
		return quLists;
	}

	public void setQuLists(List<Qudao> quLists) {
		this.quLists = quLists;
	}

	public String getQuDao() {
		List<Qudao> tj = quDaoServer.getTj();
		quLists = quDaoServer.getQudaos(page);
		if (tj != null && !tj.isEmpty()) {
			quLists.addAll(tj);
		}
		Collections.sort(quLists);
		ActionContext.getContext().getSession().put("qudaoPage", page);
		return SUCCESS;
	}
	
	public String updateQuDao(){
		quDaoServer.updateState(id, type);
		return SUCCESS;
	}
	
	public String getUserQuDao(){
		quLists=quDaoServer.getQudaos(page, id);
		ActionContext.getContext().getSession().put("qudaoPage", page);
		return SUCCESS;
	}

}
