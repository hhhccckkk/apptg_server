package com.hck.apptg.phone.action;

import java.sql.Timestamp;
import java.util.List;

import com.hck.apptg.bean.Tongzhi;
import com.hck.apptg.daoserver.TongZhiServer;
import com.hck.apptg.vo.Contans;

public class TongZhiAction extends BaseAction {
	private TongZhiServer tongZhiServer;

	public TongZhiServer getTongZhiServer() {
		return tongZhiServer;
	}

	public void setTongZhiServer(TongZhiServer tongZhiServer) {
		this.tongZhiServer = tongZhiServer;
	}

	public void addTZ() {
		init();
		String titleString = getStringData("title");
		String content = getStringData("content");
		long uid = getLongData("id");
		long huid = getLongData("huid");
		int type = getIntData("type");
		Tongzhi tongzhi = new Tongzhi();
		tongzhi.setContent(content);
		tongzhi.setHuid(huid);
		tongzhi.setUid(uid);
		tongzhi.setTitle(titleString);
		tongzhi.setShijian(new Timestamp(System.currentTimeMillis()).toString());
		tongZhiServer.addTz(tongzhi);
		tongzhi.setType(type);
		json.put("code", Contans.SUCCESS);
		write();
	}

	public void getTz() {
		init();
		long uid = getLongData("id");
		List<Tongzhi> tongzhis = tongZhiServer.getTongzhis(uid);
		if (tongzhis != null && !tongzhis.isEmpty()) {
			json.put("code", Contans.SUCCESS);
			json.put("data", tongzhis);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	public void deleteTz() {
		init();
		long id = getLongData("id");
		boolean isok = tongZhiServer.deleteTongZhi(id);
		json.put("code", isok);
		write();
	}

}
