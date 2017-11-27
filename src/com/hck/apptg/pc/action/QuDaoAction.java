package com.hck.apptg.pc.action;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.hck.apptg.bean.Qudao;
import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.QuDaoServer;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class QuDaoAction extends BaseAction {
	private QuDaoServer quDaoServer;
	private List<Qudao> quLists;
    private int type;
    private Qudao qudao;
	public int getType() {
		return type;
	}

	private String liangjiString[]={"100-499","500-1500","1500-3500","3500-6500"};

	public Qudao getQudao() {
		return qudao;
	}



	public void setQudao(Qudao qudao) {
		this.qudao = qudao;
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

	public String getQuDaos() {
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
	
	public String addQuDao(){
		if (qudao.getContent()==null) {
			addActionError("内容不能为空");
		}
		else  {
			User user=qudao.getUser();
			long uid=(new Random().nextInt(60)+1);
			int liangji=(new Random().nextInt(3));
			user.setId(uid);
			qudao.setQq(qudao.getUser().getQq());
			qudao.setWeixin(qudao.getUser().getWeixin());
			qudao.setPhone(qudao.getUser().getPhone());
			qudao.setUser(user);
			qudao.setIsok(1);
			qudao.setIstj(0);
			if (liangji>=liangjiString.length) {
				liangji=2;
			}
			qudao.setLiangji(liangjiString[liangji]);
			qudao.setShijian(new Timestamp(System.currentTimeMillis()).toString());
			quDaoServer.addQuDao(qudao);
			addActionError("增加成功");
		}
		return SUCCESS;
	}

}
