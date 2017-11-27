package com.hck.apptg.phone.action;

import com.hck.apptg.daoserver.VersionServer;

public class VersionAction extends BaseAction {
	private VersionServer server;

	public VersionServer getServer() {
		return server;
	}

	public void setServer(VersionServer server) {
		this.server = server;
	}

	public void getVersion() {
		init();
		json.put("data", server.getVersion());
		write();
	}

}
