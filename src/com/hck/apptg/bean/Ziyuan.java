package com.hck.apptg.bean;

/**
 * Ziyuan entity. @author MyEclipse Persistence Tools
 */

public class Ziyuan implements java.io.Serializable, Comparable {

	// Fields

	private Long id;
	private User user;
	private String title;
	private String content;
	private Integer isok;
	private Integer jiage;
	private String jiesuantime;
	private String fabukind;
	private String fabutime;
	private String apptype;
	private String hedui;
	private Integer istj;
	private Long huifunum;
	private String qq;
	private String phone;
	private String weixin;
	private String appName;
	private String xitong;

	// Constructors

	/** default constructor */
	public Ziyuan() {
	}

	/** full constructor */
	public Ziyuan(User user, String title, String content, Integer isok,
			Integer jiage, String jiesuantime, String fabukind,
			String fabutime, String apptype, String hedui, Integer istj,
			Long huifunum, String qq, String phone, String weixin,
			String appName, String xitong) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.isok = isok;
		this.jiage = jiage;
		this.jiesuantime = jiesuantime;
		this.fabukind = fabukind;
		this.fabutime = fabutime;
		this.apptype = apptype;
		this.hedui = hedui;
		this.istj = istj;
		this.huifunum = huifunum;
		this.qq = qq;
		this.phone = phone;
		this.weixin = weixin;
		this.appName = appName;
		this.xitong = xitong;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsok() {
		return this.isok;
	}

	public void setIsok(Integer isok) {
		this.isok = isok;
	}

	public Integer getJiage() {
		return this.jiage;
	}

	public void setJiage(Integer jiage) {
		this.jiage = jiage;
	}

	public String getJiesuantime() {
		return this.jiesuantime;
	}

	public void setJiesuantime(String jiesuantime) {
		this.jiesuantime = jiesuantime;
	}

	public String getFabukind() {
		return this.fabukind;
	}

	public void setFabukind(String fabukind) {
		this.fabukind = fabukind;
	}

	public String getFabutime() {
		return this.fabutime;
	}

	public void setFabutime(String fabutime) {
		this.fabutime = fabutime;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getHedui() {
		return this.hedui;
	}

	public void setHedui(String hedui) {
		this.hedui = hedui;
	}

	public Integer getIstj() {
		return this.istj;
	}

	public void setIstj(Integer istj) {
		this.istj = istj;
	}

	public Long getHuifunum() {
		return this.huifunum;
	}

	public void setHuifunum(Long huifunum) {
		this.huifunum = huifunum;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getXitong() {
		return this.xitong;
	}

	public void setXitong(String xitong) {
		this.xitong = xitong;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Ziyuan) {
			Ziyuan emp = (Ziyuan) o;
			return emp.istj-this.istj;
		}
		return 0;

	}

}