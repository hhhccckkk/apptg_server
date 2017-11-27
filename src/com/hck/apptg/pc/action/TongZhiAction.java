package com.hck.apptg.pc.action;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import com.hck.apptg.bean.Tongzhi;
import com.hck.apptg.daoserver.TongZhiServer;

public class TongZhiAction extends BaseAction {
	private TongZhiServer zTongZhiServer;
	private List<Tongzhi> tongzhis;
	private Tongzhi tongzhi;

	public TongZhiServer getzTongZhiServer() {
		return zTongZhiServer;
	}

	public void setzTongZhiServer(TongZhiServer zTongZhiServer) {
		this.zTongZhiServer = zTongZhiServer;
	}

	public List<Tongzhi> getTongzhis() {
		return tongzhis;
	}

	public void setTongzhis(List<Tongzhi> tongzhis) {
		this.tongzhis = tongzhis;
	}

	public Tongzhi getTongzhi() {
		return tongzhi;
	}

	public void setTongzhi(Tongzhi tongzhi) {
		this.tongzhi = tongzhi;
	}

	public String addTongZhi() {
		tongzhi.setHuid(0l);
		tongzhi.setUid(0l);
		tongzhi.setType(2); // 系统消息,1关注信息
		tongzhi.setShijian(new Timestamp(System.currentTimeMillis()).toString());
		zTongZhiServer.addTz(tongzhi);
		return SUCCESS;
	}

	public String deleteTongZhi() {
		zTongZhiServer.deleteTongZhi(id);
		return SUCCESS;
	}

	public String getTongZhis() {
		tongzhis = zTongZhiServer.getTongzhiXT();
		Collections.sort(tongzhis);
		return SUCCESS;
	}

}
