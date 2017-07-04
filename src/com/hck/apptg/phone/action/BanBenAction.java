package com.hck.apptg.phone.action;

import com.hck.apptg.bean.Version;
import com.hck.apptg.daoserver.BanBenServer;
import com.hck.apptg.vo.Contans;

public class BanBenAction extends BaseAction {
	private BanBenServer banBenServer;

	public BanBenServer getBanBenServer() {
		return banBenServer;
	}

	public void setBanBenServer(BanBenServer banBenServer) {
		this.banBenServer = banBenServer;
	}

	public void getBenBen() {
		init();
		int id = getIntData("id");
		Version version = banBenServer.getVersion(id);
		if (version != null) {
			json.put("data", version);
			json.put("code", Contans.SUCCESS);

		} else {
			json.put("code", Contans.ERROR);
		}
		write();

	}

}
