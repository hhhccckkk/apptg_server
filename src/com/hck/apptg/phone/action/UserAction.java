package com.hck.apptg.phone.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.UserDaoServer;
import com.hck.apptg.duiba.CreditTool;
import com.hck.apptg.vo.Contans;
import com.hck.apptg.vo.UserData;

public class UserAction extends BaseAction {
	private UserDaoServer uDao;

	public UserDaoServer getuDao() {
		return uDao;
	}

	public void setuDao(UserDaoServer uDao) {
		this.uDao = uDao;
	}

	/**
	 * �����û�
	 */
	public void addUser() {
		init();
		String imei = getStringData("imei");
		String phoneString = getStringData("phone");
		String nameString = getStringData("name");
		String nicheng = getStringData("nicheng");
		String address = getStringData("address");
		double jingdu = getDoubleData("jindu");
		double weidu = getDoubleData("weidu");
		String touxiang = getStringData("touxiang");
		String phoneTypeString = getStringData("phoneName");
		String gongsi = getStringData("gongsi");
		String jieshao = getStringData("jieshao");
		String qqIdString = getStringData("qqId");
		String qq = getStringData("qq");
		String weixin = getStringData("weixin");
		int sex = getIntData("sex");
		int type = getIntData("type");
		User oldUser = uDao.userExit(new User(qqIdString, jingdu, weidu));
		if (oldUser == null) {
			User newUser = new User();
			newUser.setAddress(address);
			newUser.setFatienum(0);
			newUser.setFensi(0l);
			newUser.setGongsi(gongsi);
			newUser.setImei(imei);
			newUser.setIsok(1);
			newUser.setIsvip(0);
			newUser.setJieshao(jieshao);
			newUser.setJifeng(0l);
			newUser.setJinbi(10l);
			newUser.setJingdu(jingdu);
			newUser.setWeidu(weidu);
			newUser.setNicheng(nicheng);
			newUser.setName(nameString);
			newUser.setPhone(phoneString);
			newUser.setPhonetype(phoneTypeString);
			newUser.setQq(qq);
			newUser.setQqid(qqIdString);
			newUser.setRegistertime(new Timestamp(System.currentTimeMillis())
					.toString());
			newUser.setSex(sex);
			newUser.setTouxiang(touxiang);
			newUser.setWeixin(weixin);
			newUser.setUsertype(type); // 1:��Դ��2����
			newUser = uDao.addUser(newUser);
			json.put("code", Contans.SUCCESS);
			json.put("user", newUser);
		} else {
			if (oldUser.getIsok() == 1) {
				json.put("code", Contans.SUCCESS);
				json.put("user", changUser(oldUser));
			} else {// �û�������
				json.put("code", Contans.JINYONG);
				json.put("user", changUser(oldUser));
			}

		}
		write();
	}

	/**
	 * �����û���Ϣ
	 */
	public void prefectUser() {
		init();
		String qq = getStringData("qq");
		String weixin = getStringData("weixin");
		String phone = getStringData("phone");
		String gongsi = getStringData("gongsi");
		String address = getStringData("address");
		String jieshao = getStringData("jieshao");
		long uid = getLongData("id");
		int type = getIntData("type");
		User user = new User();
		user.setAddress(address);
		user.setGongsi(gongsi);
		user.setWeixin(weixin);
		user.setQq(qq);
		user.setId(uid);
		user.setJieshao(jieshao);
		user.setPhone(phone);
		user.setUsertype(type);
		User newUser = uDao.prefectUser(user);
		if (newUser != null) {
			json.put("code", Contans.SUCCESS);
			json.put("user", changUser(newUser));
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	/**
	 * �����û�pushid
	 */
	public void updateUserPushId() {
		init();
		String pushIdString = getStringData("pushid");
		long uid = getLongData("id");
		User user = new User();
		user.setPushid(pushIdString);
		user.setId(uid);
		user = uDao.updateUserPushId(user);
		if (user != null) {
			json.put("code", Contans.SUCCESS);
			json.put("user", changUser(user));
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	public void getOneUser() {
		init();
		User user = uDao.getUser(id);
		if (user != null) {
			json.put("code", Contans.SUCCESS);
			json.put("user", changUser(user));
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	@SuppressWarnings("unchecked")
	public void getLoginUrl() {
		init();
		String url = null;
		long uid = getLongData("id");
		User user = uDao.getUser(uid);
		if (uid <= 0 || user == null || user.getIsok() != 1) {
			json.put("isok", false);
		} else {		
			CreditTool tool = new CreditTool(Contans.DUIHUANG_BA_KEY,
					Contans.DUIHUANG_BA_Secret);
			Map params=new HashMap();
			params.put("uid",uid+"");
			params.put("credits",user.getJinbi()+"");
			String redirect = "http://home.m.duiba.com.cn/chome/index";
			if(redirect!=null){
			    params.put("redirect",redirect);
			}
			url=tool.buildUrlWithSign("http://www.duiba.com.cn/autoLogin/autologin?",params);
			json.put("isok", true);
			json.put("url", url);
		}
		write();

	}

	public UserData changUser(User user) {
		UserData userData = new UserData(user.getName(), user.getPassword(),
				user.getSex(), user.getNicheng(), user.getTouxiang(),
				user.getPushid(), user.getQq(), user.getWeixin(),
				user.getPhone(), user.getPhonetype(), user.getAddress(),
				user.getImei(), user.getJingdu(), user.getWeidu(),
				user.getIsok(), user.getIsvip(), user.getLogintime(),
				user.getRegistertime(), user.getJifeng(), user.getJinbi(),
				user.getGongsi(), user.getJieshao(), user.getFensi(),
				user.getFatienum(), user.getQqid(), user.getUsertype());
		userData.setId(user.getId());
		return userData;
	}
}
