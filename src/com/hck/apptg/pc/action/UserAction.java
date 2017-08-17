package com.hck.apptg.pc.action;

import java.util.List;

import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.UserDaoServer;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {
	private List<User> users;
	private UserDaoServer uServer;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDaoServer getuServer() {
		return uServer;
	}

	public void setuServer(UserDaoServer uServer) {
		this.uServer = uServer;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getusers() {
		users = uServer.getUsers(page);
		ActionContext.getContext().getSession().put("userPage", page);
		return SUCCESS;
	}

	public String deleteUser() {
		
		return SUCCESS;
	}
}
