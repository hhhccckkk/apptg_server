package com.hck.apptg.pc.action;

import com.hck.apptg.bean.Admin;
import com.hck.apptg.daoserver.AdminServer;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class AdminAction extends BaseAction {
	private AdminServer mAdminServer;
	private Admin admin;

	public AdminServer getmAdminServer() {
		return mAdminServer;
	}

	public void setmAdminServer(AdminServer mAdminServer) {
		this.mAdminServer = mAdminServer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login() {
		Admin admin2=mAdminServer.login(admin);
		if (admin2!=null) {
			ActionContext.getContext().getSession().put("admin",admin2);
			return SUCCESS;
		}
		addActionError("登陆失败");
		return ERROR;
	}

}
