package com.hck.apptg.phone.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.hck.apptg.bean.Qudao;
import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.JinBiServer;
import com.hck.apptg.daoserver.QuDaoServer;
import com.hck.apptg.vo.Contans;
import com.hck.apptg.vo.QudaoData;

public class QuDaoAction extends BaseAction {
	private QuDaoServer mDaoServer;
	private JinBiServer jinBiServer;

	public JinBiServer getJinBiServer() {
		return jinBiServer;
	}

	public void setJinBiServer(JinBiServer jinBiServer) {
		this.jinBiServer = jinBiServer;
	}

	public QuDaoServer getmDaoServer() {
		return mDaoServer;
	}

	public void setmDaoServer(QuDaoServer mDaoServer) {
		this.mDaoServer = mDaoServer;
	}

	public void getQudaos() {
		init();
		int key = getIntData("key");
		List<Qudao> qudaos = mDaoServer.getQudaos(page, key);
		if (key <= 0 && page==1) {
			List<Qudao> tj = mDaoServer.getTj();
			if (tj != null && !tj.isEmpty()) {
				qudaos.addAll(tj);
				Collections.sort(qudaos);
			}
		}
		if (qudaos != null && !qudaos.isEmpty()) {
			json.put("code", Contans.SUCCESS);
			json.put("data", changeData(qudaos));
		} else {
			json.put("code", Contans.ERROR);
		}
		write();

	}

	public void addQuDaoInfo() {
		init();
		String title = getStringData("title");
		String kind = getStringData("kind");
		String liangji = getStringData("liangji");
		String content = getStringData("content");
		String qq = getStringData("qq");
		String wx = getStringData("wx");
		String phone = getStringData("phone");
		int dengji = getIntData("dengji");
		String wangzhi = getStringData("wangzhi");
		Qudao qudao = new Qudao();
		qudao.setContent(content);
		qudao.setHuifunum(0l);
		qudao.setLeixing(kind);
		qudao.setLiangji(liangji);
		qudao.setPhone(phone);
		qudao.setQq(qq);
		qudao.setTitle(title);
		qudao.setWeixin(wx);
		qudao.setDengji(dengji);
		qudao.setIsok(1);
		qudao.setIstj(0);
		qudao.setLianjie(wangzhi);
		qudao.setShijian(new Timestamp(System.currentTimeMillis()).toString());
		User user = new User();
		user.setId(id);
		qudao.setUser(user);
		if (mDaoServer.addQuDao(qudao)) {
			boolean isok = jinBiServer.isAddJinBi(id, 50, 10);
			json.put("isok", isok);
			json.put("code", Contans.SUCCESS);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	private List<QudaoData> changeData(List<Qudao> qudaos) {
		
		List<QudaoData> datas = new ArrayList<QudaoData>();
		for (Qudao qudao : qudaos) {
			QudaoData qudaoData = new QudaoData();
			qudaoData.setContent(qudao.getContent());
			qudaoData.setHuifunum(qudao.getHuifunum());
			qudaoData.setId(qudao.getId());
			User user = qudao.getUser();
			qudaoData.setJifeng(user.getJifeng());
			qudaoData.setLeixing(qudao.getLeixing());
			qudaoData.setLiangji(qudao.getLiangji());
			qudaoData.setName(user.getNicheng());
			qudaoData.setPhone(user.getPhone());
			qudaoData.setQq(user.getQq());
			qudaoData.setSex(user.getSex());
			qudaoData.setShijian(qudao.getShijian());
			qudaoData.setTitle(qudao.getTitle());
			qudaoData.setTouxiang(user.getTouxiang());
			qudaoData.setUid(user.getId());
			qudaoData.setWeixin(user.getWeixin());
			qudaoData.setXitong(qudao.getXitong());
			qudaoData.setLianjie(qudao.getLianjie());
			qudaoData.setFensi(user.getFensi());
		     qudaoData.setIstj(qudao.getIstj());
			datas.add(qudaoData);
		}
		return datas;

	}

}
