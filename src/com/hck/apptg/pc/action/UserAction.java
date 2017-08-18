package com.hck.apptg.pc.action;

import java.util.List;

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
	
	public String searchUser(){
		users = uServer.searchUser(key);
		if (users!=null &&!users.isEmpty()) {
			user=users.get(0);
		}
		return SUCCESS;
	}
	
	public String getUserSize(){
		size=(int) uServer.getUserSize(type);
		return SUCCESS;
	}

	
}
