package com.hck.apptg.pc.action;

import java.util.List;

import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.UserDaoServer;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {
	private List<User> users;
	private UserDaoServer uServer;
	private long id;
	private User user;
    

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

	
}
