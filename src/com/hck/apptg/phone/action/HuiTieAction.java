package com.hck.apptg.phone.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hck.apptg.bean.Huitie;
import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.HUiTieServer;
import com.hck.apptg.daoserver.JinBiServer;
import com.hck.apptg.util.LogUtil;
import com.hck.apptg.vo.Contans;
import com.hck.apptg.vo.HuiTieData;

public class HuiTieAction extends BaseAction {
	private HUiTieServer hServer;
    private JinBiServer jinBiServer;
    
	public JinBiServer getJinBiServer() {
		return jinBiServer;
	}

	public void setJinBiServer(JinBiServer jinBiServer) {
		this.jinBiServer = jinBiServer;
	}

	public HUiTieServer gethServer() {
		return hServer;
	}

	public void sethServer(HUiTieServer hServer) {
		this.hServer = hServer;
	}

	public void addHuiTie() {
		init();
		long uid = getLongData("id");
		long tid = getLongData("tid");
		long buid=getLongData("buid");
		String yuantie = getStringData("yuantie");
		String huitie1 = getStringData("huitie1");
		String huitie = getStringData("huitie");
		Huitie huitie2 = new Huitie();
		huitie2.setImage("");
		huitie2.setTid(tid);
		huitie2.setBuid(buid);
		huitie2.setTime(new Timestamp(System.currentTimeMillis()).toString());
		huitie2.setYuantie(yuantie);
		User user = new User();
		user.setId(uid);
		huitie2.setUser(user);
		huitie2.setHuifu(huitie);
		huitie2.setHuifu1(huitie1);
		boolean isok = hServer.addHuiTie(huitie2);
		if (isok) {
			boolean isok2 = jinBiServer.isAddJinBi(uid, 50, 10);
			json.put("isok", isok2);
			json.put("code", Contans.SUCCESS);

		} else {
			json.put("code", Contans.ERROR);

		}
		write();
	}
  
	public void getHuiTies() {
		init();
		long tid = getLongData("tid");
		List<Huitie> huities = hServer.getHuities(tid);
		if (huities != null) {
			json.put("code", Contans.SUCCESS);
			json.put("data", changeDatas(huities));

		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}
	
	public void getHuiFus() {
		init();
		long id = getLongData("uid");
		List<Huitie> huities = hServer.getHuiFus(id);
		if (huities != null) {
			json.put("code", Contans.SUCCESS);
			json.put("data", changeDatas(huities));

		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

	public List<HuiTieData> changeDatas(List<Huitie> huities) {
		List<HuiTieData> huiTieDatas = new ArrayList<HuiTieData>();
		for (Huitie huitie : huities) {
			HuiTieData huiTieData = new HuiTieData();
			huiTieData.setHtieId(huitie.getId());
			huiTieData.setTid(huitie.getTid());
			huiTieData.setYuantie(huitie.getYuantie());
			huiTieData.setHuitie(huitie.getHuifu());
			huiTieData.setHuifu1(huitie.getHuifu1());
			User user = huitie.getUser();
			if (user != null) {
				huiTieData.setTouxiang(user.getTouxiang());
				huiTieData.setNicheng(user.getNicheng());
				huiTieData.setSex(user.getSex());
				huiTieData.setId(user.getId());
				huiTieData.setFensi(user.getFensi());
				huiTieData.setJifeng(user.getJifeng());
			}
			huiTieDatas.add(huiTieData);
		}
		return huiTieDatas;
	}

}
