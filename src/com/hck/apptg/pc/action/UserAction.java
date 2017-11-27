package com.hck.apptg.pc.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.UserDaoServer;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {
	private static final int TODY_SIZE = 1;
	private static final int ZUOTIAN_SIZE = 2;
	private List<User> users;
	private UserDaoServer uServer;
	private long id;
	private User user;
	private String key;
	private int size;
	private int type;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserDaoServer getuServer() {
		return uServer;
	}

	public void setuServer(UserDaoServer uServer) {
		this.uServer = uServer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getusers() {
		users = uServer.getUsers(page);
		ActionContext.getContext().getSession().put("userPage", page);
		return SUCCESS;
	}

	public String getOneUser() {
		user = uServer.getUser(id);
		return SUCCESS;
	}

	public String searchUser() {
		users = uServer.searchUser(key);
		if (users != null && !users.isEmpty()) {
			user = users.get(0);
		}
		return SUCCESS;
	}

	public String getUserSize() {
		size = (int) uServer.getUserSize(type);
		return SUCCESS;
	}

	public String addUser() {
		
		user.setAddress("四川成都");
		user.setFatienum(0);
		user.setFensi(0l);
		user.setGongsi("");
		user.setGuanzhu(0l);
		user.setImei("hckhck1");
		user.setIsok(1);
		user.setIsvip(0);
		user.setJieshao("暂无");
		user.setJifeng(0l);
		user.setJinbi(0l);
		user.setJingdu(1.0);
		user.setWeidu(1.0);
		user.setLogintime("2017-8-18");
		user.setRegistertime(new Timestamp(System.currentTimeMillis())
				.toString());
		user.setName("hckhck1");
		user.setPhone("暂无");
		user.setPhonetype("系统");
		user.setPushid("暂无");
		user.setQq("暂无");
		user.setWeixin("暂无");
		user.setPhone("暂无");
		user.setUsertype(0);
		user.setSex((new Random().nextInt(2) + 1));
		String tx="http://139.224.190.65:8080/apptg/admin/touxiang/";
		tx=tx+user.getTouxiang();
		user.setPassword("hck1");
		user.setGongsi("无");
		user.setPushid("hck");
		user.setQqid("hck");
		user.setTouxiang(tx);
		uServer.addUser(user);
		return SUCCESS;

	}

}
