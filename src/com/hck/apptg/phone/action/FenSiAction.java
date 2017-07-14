package com.hck.apptg.phone.action;

import java.sql.Timestamp;
import java.util.List;

import com.hck.apptg.bean.Fensi;
import com.hck.apptg.daoserver.FenSiServer;
import com.hck.apptg.daoserver.UserDaoServer;
import com.hck.apptg.util.LogUtil;
import com.hck.apptg.vo.Contans;

public class FenSiAction extends BaseAction {
	private FenSiServer fServer;
    private UserDaoServer uServer;
    
	public UserDaoServer getuServer() {
		return uServer;
	}

	public void setuServer(UserDaoServer uServer) {
		this.uServer = uServer;
	}

	public FenSiServer getfServer() {
		return fServer;
	}

	public void setfServer(FenSiServer fServer) {
		this.fServer = fServer;
	}

	public void getFensis() {
		init();
		long uid = getLongData("id");
		List<Fensi> fensis = fServer.getFensis(uid);
		if (fensis != null && !fensis.isEmpty()) {
			json.put("code", Contans.SUCCESS);
			json.put("data", fensis);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}
	
	
	public void getGuanZhus() {
		init();
		long uid = getLongData("id");
		List<Fensi> fensis = fServer.getGuanZhus(uid);
		if (fensis != null && !fensis.isEmpty()) {
			json.put("code", Contans.SUCCESS);
			json.put("data", fensis);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	public void deleteFenSi() {
		init();
		long uid = getLongData("id");
		boolean isok = fServer.deleteFenSi(uid);
		if (isok) {
			uServer.updateUserFenSi(uid,-1);
			json.put("code", Contans.SUCCESS);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	public void addFenSi() {
		init();
		long uid = getLongData("id");
		long fuid = getLongData("fuid");
		String ftx = getStringData("ftx");
		String fname = getStringData("fname");
		String tx = getStringData("tx");
		String name = getStringData("name");
		if (fServer.isGuanZhu(uid, fuid)) {
			json.put("code", Contans.SUCCESS);
			json.put("type", 0);
		}
		else {
			Fensi fensi = new Fensi();
			fensi.setUid(uid);
			fensi.setFuid(fuid);
			fensi.setName(name);
			fensi.setFname(fname);
			fensi.setFtouxiang(ftx);
			fensi.setTime(new Timestamp(System.currentTimeMillis()).toString());
			fensi.setTouxiang(tx);
			boolean isok = fServer.addFenSi(fensi);
			if (isok) {
				uServer.updateUserFenSi(uid,1);
				uServer.updateUserGuangZhu(fuid);
				json.put("code", Contans.SUCCESS);
				json.put("type", 1);
			} else {
				json.put("code", Contans.ERROR);
			}
		}
		write();
	}

}
