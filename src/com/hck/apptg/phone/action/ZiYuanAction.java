package com.hck.apptg.phone.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hck.apptg.bean.User;
import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.daoserver.JinBiServer;
import com.hck.apptg.daoserver.ZiYuanDaoServer;
import com.hck.apptg.vo.Contans;
import com.hck.apptg.vo.ZiYuanData;

public class ZiYuanAction extends BaseAction {
	private ZiYuanDaoServer mZiYuanDaoServer;
	private JinBiServer jinBiServer;

	public JinBiServer getJinBiServer() {
		return jinBiServer;
	}

	public void setJinBiServer(JinBiServer jinBiServer) {
		this.jinBiServer = jinBiServer;
	}

	private static final int DEFAULT_NUM = 10;

	public ZiYuanDaoServer getmZiYuanDaoServer() {
		return mZiYuanDaoServer;
	}

	public void setmZiYuanDaoServer(ZiYuanDaoServer mZiYuanDaoServer) {
		this.mZiYuanDaoServer = mZiYuanDaoServer;
	}

	public void addZiYuan() {
		init();
		long uid = getLongData("id");
		String title = getStringData("title");
		String content = getStringData("content");
		int jiage = getIntData("jiage");
		String xitong = getStringData("xitong");
		String jiesuantime = getStringData("jiesuantime");
		String fabukind = getStringData("fabukind");
		String apptype = getStringData("apptype");
		String hedui = getStringData("hedui");
		String qq = getStringData("qq");
		String phone = getStringData("phone");
		String weixin = getStringData("weixin");
		String appName = getStringData("appName");
		Ziyuan ziyuan = new Ziyuan();
		ziyuan.setApptype(apptype);
		ziyuan.setContent(content);
		ziyuan.setFabukind(fabukind);
		ziyuan.setFabutime(new Timestamp(System.currentTimeMillis()).toString());
		ziyuan.setHedui(hedui);
		ziyuan.setHuifunum(0L);
		ziyuan.setIsok(1);
		ziyuan.setIstj(0);
		ziyuan.setJiage(jiage);
		ziyuan.setJiesuantime(jiesuantime);
		ziyuan.setPhone(phone);
		ziyuan.setQq(qq);
		ziyuan.setTitle(title);
		User user = new User();
		user.setId(uid);
		ziyuan.setUser(user);
		ziyuan.setWeixin(weixin);
		ziyuan.setXitong(xitong);
		ziyuan.setAppName(appName);
		long id = mZiYuanDaoServer.addZiYuan(ziyuan);
		if (id > 0) {
			boolean isok = jinBiServer.isAddJinBi(uid, 50, 10);
			json.put("isok", isok);
			json.put("code", Contans.SUCCESS);
			json.put("id", id);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	/**
	 * 默认获取资源信息
	 */
	public void getZiYuanInfos() {
		init();
		List<Ziyuan> ziyuans = mZiYuanDaoServer
				.getZiYuanInfo(page, DEFAULT_NUM);
		if (ziyuans != null && !ziyuans.isEmpty()) {
			json.put("data", changeData(ziyuans));
			json.put("code", Contans.SUCCESS);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	/**
	 * 更具关键字检索资源
	 */
	public void getZiyuans() {
		init();
		int key = getIntData("key");
		List<Ziyuan> ziyuans = mZiYuanDaoServer.getZiyuans(page, key);
		if (ziyuans != null && !ziyuans.isEmpty()) {
			json.put("data", changeData(ziyuans));
			json.put("code", Contans.SUCCESS);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	public List<ZiYuanData> changeData(List<Ziyuan> ziyuans) {
		List<ZiYuanData> ziYuanDatas = new ArrayList<ZiYuanData>();
		if (ziyuans == null) {
			return null;
		}
		for (int i = 0; i < ziyuans.size(); i++) {
			ZiYuanData ziYuanData = new ZiYuanData();
			Ziyuan ziyuan = ziyuans.get(i);
			ziYuanData.setAppName(ziyuan.getAppName());
			ziYuanData.setApptype(ziyuan.getApptype());
			ziYuanData.setContent(ziyuan.getContent());
			ziYuanData.setFabukind(ziyuan.getFabukind());
			ziYuanData.setFabutime(ziyuan.getFabutime());
			ziYuanData.setHedui(ziyuan.getHedui());
			ziYuanData.setHuifunum(ziyuan.getHuifunum());
			ziYuanData.setId(ziyuan.getId());
			ziYuanData.setIsok(ziyuan.getIsok());
			ziYuanData.setIstj(ziyuan.getIstj());
			ziYuanData.setJiage(ziyuan.getJiage());
			ziYuanData.setJiesuantime(ziyuan.getJiesuantime());
			ziYuanData.setTitle(ziyuan.getTitle());
			ziYuanData.setXitong(ziyuan.getXitong());
			ziYuanData.setQq(ziyuan.getQq());
			ziYuanData.setWeixin(ziyuan.getWeixin());
			ziYuanData.setPhone(ziyuan.getPhone());
			User user = ziyuan.getUser();
			if (user != null) {
				ziYuanData.setJifeng(user.getJifeng());
				ziYuanData.setJinbi(user.getJinbi());
				ziYuanData.setTouxiang(user.getTouxiang());
				ziYuanData.setName(user.getNicheng());
				ziYuanData.setUserPhone(user.getPhone());
				ziYuanData.setVip(user.getIsvip());
				ziYuanData.setSex(user.getSex());
				ziYuanData.setUid(user.getId());
			}
			ziYuanDatas.add(ziYuanData);
		}

		return ziYuanDatas;

	}

}
