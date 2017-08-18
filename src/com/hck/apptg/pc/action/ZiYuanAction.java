package com.hck.apptg.pc.action;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import com.hck.apptg.bean.User;
import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.daoserver.ZiYuanDaoServer;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class ZiYuanAction extends BaseAction {
	private ZiYuanDaoServer ziYuanDaoServer;
	private List<Ziyuan> ziyuans;
	private long id;
	private int type;
    private Ziyuan ziyuan;
    private String key;
    
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Ziyuan getZiyuan() {
		return ziyuan;
	}

	public void setZiyuan(Ziyuan ziyuan) {
		this.ziyuan = ziyuan;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Ziyuan> getZiyuans() {
		return ziyuans;
	}

	public void setZiyuans(List<Ziyuan> ziyuans) {
		this.ziyuans = ziyuans;
	}

	public ZiYuanDaoServer getZiYuanDaoServer() {
		return ziYuanDaoServer;
	}

	public void setZiYuanDaoServer(ZiYuanDaoServer ziYuanDaoServer) {
		this.ziYuanDaoServer = ziYuanDaoServer;
	}

	@SuppressWarnings("unchecked")
	public String getZiYuans() {
		List<Ziyuan> tj = ziYuanDaoServer.getZiyuanTJ();

		ziyuans = ziYuanDaoServer.getZiYuanInfo(page);
		if (tj != null && !tj.isEmpty()) {
			ziyuans.addAll(tj);
			Collections.sort(ziyuans);
		}
		ActionContext.getContext().getSession().put("ziyuanPage", page);
		return SUCCESS;
	}

	public String updateZiYuan() {
		if (type == 1) {
			ziYuanDaoServer.tuijian(id);
		} else {
			ziYuanDaoServer.updateZiYuan(id);
		}
		return SUCCESS;
	}

	public String getUserTieZi() {
		
		ziyuans = ziYuanDaoServer.getUserTieZi(page, id);
		LogUtil.log("ziyuansziyuansziyuansziyuans: "+ziyuans.size() +"id: "+id);
		ActionContext.getContext().getSession().put("ziyuanPage", page);
		return SUCCESS;
	}
	
	public String addZiYuan(){
		if (ziyuan.getAppName()==null) {
			addActionError("app名字不能为空");
		}
		else if (ziyuan.getContent()==null) {
			addActionError("详细内容不能为空");
		}
		else if (ziyuan.getTitle()==null) {
			addActionError("标题不能为空");
		}
		else {
			ziyuan.setFabutime(new Timestamp(System.currentTimeMillis()).toString());
			ziyuan.setIsok(1);
			ziyuan.setIstj(0);
			User user=new User();
			user.setId(29l);
			ziyuan.setUser(user);
			ziYuanDaoServer.addZiYuan(ziyuan);
			addActionError("增加成功");
		}
		return SUCCESS;
	}
	
	public String searchZiYuan(){
		ziyuans=ziYuanDaoServer.searchUser(key);
		return SUCCESS;
	}

}
