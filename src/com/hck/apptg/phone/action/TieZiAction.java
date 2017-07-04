package com.hck.apptg.phone.action;

import java.util.ArrayList;
import java.util.List;

import com.hck.apptg.bean.Qudao;
import com.hck.apptg.bean.User;
import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.daoserver.TieZiServer;
import com.hck.apptg.vo.Contans;
import com.hck.apptg.vo.TieZi;

public class TieZiAction extends BaseAction {
	private TieZiServer tieZiServer;

	public TieZiServer getTieZiServer() {
		return tieZiServer;
	}

	public void setTieZiServer(TieZiServer tieZiServer) {
		this.tieZiServer = tieZiServer;
	}

	public void getUserTieZi() {
		init();
		long uid = getLongData("id");
		List<Ziyuan> ziyuans = tieZiServer.getZiyuans(uid);
		List<Qudao> qudaos = tieZiServer.getQudaos(uid);
		List<TieZi> tieZis = new ArrayList<TieZi>();
		if (ziyuans != null) {
			for (Ziyuan ziyuan : ziyuans) {
				TieZi tieZi = new TieZi();
				tieZi.setTid(ziyuan.getId());
				tieZi.setTime(ziyuan.getFabutime());
				tieZi.setTitle(ziyuan.getTitle());
				tieZi.setType(1);
				tieZi.setUid(ziyuan.getUser().getId());
				User user = ziyuan.getUser();
				tieZi.setContent(ziyuan.getContent());
				tieZi.setLeixing(ziyuan.getXitong());
				tieZi.setPhone(ziyuan.getPhone());
				tieZi.setQq(ziyuan.getQq());
				tieZi.setSex(user.getSex());
				tieZi.setTouxiang(user.getTouxiang());
				tieZi.setName(user.getNicheng());
				tieZi.setWeixin(user.getWeixin());
			}
		}
		if (qudaos != null) {
			for (Qudao qudao : qudaos) {
				TieZi tieZi = new TieZi();
				tieZi.setTid(qudao.getId());
				tieZi.setTime(qudao.getShijian());
				tieZi.setTitle(qudao.getTitle());
				tieZi.setType(2);
				tieZi.setUid(qudao.getUser().getId());
				tieZi.setContent(qudao.getContent());
				tieZi.setLiangji(qudao.getLiangji());
				tieZi.setPhone(qudao.getPhone());
				tieZi.setQq(qudao.getQq());
				tieZi.setWeixin(qudao.getWeixin());
				tieZi.setLeixing(qudao.getLeixing());
				tieZi.setLianjie(qudao.getLianjie());
				tieZi.setSex(qudao.getUser().getSex());
				tieZi.setTouxiang(qudao.getUser().getTouxiang());
				tieZi.setName(qudao.getUser().getNicheng());
			}
		}
		if (tieZis != null && !tieZis.isEmpty()) {
			json.put("data", tieZis);
			json.put("code", Contans.SUCCESS);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();

	}

}
