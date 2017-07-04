package com.hck.apptg.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class UserData implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String password;
	private Integer sex;
	private String nicheng;
	private String touxiang;
	private String pushid;
	private String qq;
	private String weixin;
	private String phone;
	private String phonetype;
	private String address;
	private String imei;
	private Double jingdu;
	private Double weidu;
	private Integer isok;
	private Integer isvip;
	private String logintime;
	private String registertime;
	private Long jifeng;
	private Long jinbi;
	private String gongsi;
	private String jieshao;
	private Long fensi;
	private Integer fatienum;
	private String qqid;
	private Integer usertype;

	public UserData() {

	}

	/** full constructor */
	public UserData(String name, String password, Integer sex, String nicheng,
			String touxiang, String pushid, String qq, String weixin,
			String phone, String phonetype, String address, String imei,
			Double jingdu, Double weidu, Integer isok, Integer isvip,
			String logintime, String registertime, Long jifeng, Long jinbi,
			String gongsi, String jieshao, Long fensi, Integer fatienum,
			String qqid, Integer usertype) {
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.nicheng = nicheng;
		this.touxiang = touxiang;
		this.pushid = pushid;
		this.qq = qq;
		this.weixin = weixin;
		this.phone = phone;
		this.phonetype = phonetype;
		this.address = address;
		this.imei = imei;
		this.jingdu = jingdu;
		this.weidu = weidu;
		this.isok = isok;
		this.isvip = isvip;
		this.logintime = logintime;
		this.registertime = registertime;
		this.jifeng = jifeng;
		this.jinbi = jinbi;
		this.gongsi = gongsi;
		this.jieshao = jieshao;
		this.fensi = fensi;
		this.fatienum = fatienum;
		this.qqid = qqid;
		this.usertype = usertype;

	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getNicheng() {
		return this.nicheng;
	}

	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
	}

	public String getTouxiang() {
		return this.touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public String getPushid() {
		return this.pushid;
	}

	public void setPushid(String pushid) {
		this.pushid = pushid;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhonetype() {
		return this.phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Double getJingdu() {
		return this.jingdu;
	}

	public void setJingdu(Double jingdu) {
		this.jingdu = jingdu;
	}

	public Double getWeidu() {
		return this.weidu;
	}

	public void setWeidu(Double weidu) {
		this.weidu = weidu;
	}

	public Integer getIsok() {
		return this.isok;
	}

	public void setIsok(Integer isok) {
		this.isok = isok;
	}

	public Integer getIsvip() {
		return this.isvip;
	}

	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}

	public String getLogintime() {
		return this.logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}

	public Long getJifeng() {
		return this.jifeng;
	}

	public void setJifeng(Long jifeng) {
		this.jifeng = jifeng;
	}

	public Long getJinbi() {
		return this.jinbi;
	}

	public void setJinbi(Long jinbi) {
		this.jinbi = jinbi;
	}

	public String getGongsi() {
		return this.gongsi;
	}

	public void setGongsi(String gongsi) {
		this.gongsi = gongsi;
	}

	public String getJieshao() {
		return this.jieshao;
	}

	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}

	public Long getFensi() {
		return this.fensi;
	}

	public void setFensi(Long fensi) {
		this.fensi = fensi;
	}

	public Integer getFatienum() {
		return this.fatienum;
	}

	public void setFatienum(Integer fatienum) {
		this.fatienum = fatienum;
	}

	public String getQqid() {
		return this.qqid;
	}

	public void setQqid(String qqid) {
		this.qqid = qqid;
	}

	public Integer getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

}