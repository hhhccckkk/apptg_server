package com.hck.apptg.bean;

/**
 * Qudao entity. @author MyEclipse Persistence Tools
 */

public class Qudao implements java.io.Serializable ,Comparable{

	// Fields

	private Long id;
	private User user;
	private String leixing;
	private String xitong;
	private String liangji;
	private String qq;
	private String weixin;
	private String phone;
	private String lianjie;
	private String content;
	private String title;
	private Long huifunum;
	private String shijian;
	private Integer dengji;
    private int isok;
    private int istj;
    

	public int getIsok() {
		return isok;
	}

	public void setIsok(int isok) {
		this.isok = isok;
	}

	public int getIstj() {
		return istj;
	}

	public void setIstj(int istj) {
		this.istj = istj;
	}

	/** default constructor */
	public Qudao() {
	}

	/** full constructor */
	public Qudao(User user, String leixing, String xitong, String liangji,
			String qq, String weixin, String phone, String lianjie,
			String content, String title, Long huifunum, String shijian,
			Integer dengji) {
		this.user = user;
		this.leixing = leixing;
		this.xitong = xitong;
		this.liangji = liangji;
		this.qq = qq;
		this.weixin = weixin;
		this.phone = phone;
		this.lianjie = lianjie;
		this.content = content;
		this.title = title;
		this.huifunum = huifunum;
		this.shijian = shijian;
		this.dengji = dengji;
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

	public String getLeixing() {
		return this.leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getXitong() {
		return this.xitong;
	}

	public void setXitong(String xitong) {
		this.xitong = xitong;
	}

	public String getLiangji() {
		return this.liangji;
	}

	public void setLiangji(String liangji) {
		this.liangji = liangji;
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

	public String getLianjie() {
		return this.lianjie;
	}

	public void setLianjie(String lianjie) {
		this.lianjie = lianjie;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getHuifunum() {
		return this.huifunum;
	}

	public void setHuifunum(Long huifunum) {
		this.huifunum = huifunum;
	}

	public String getShijian() {
		return this.shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public Integer getDengji() {
		return this.dengji;
	}

	public void setDengji(Integer dengji) {
		this.dengji = dengji;
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Qudao) {
			Qudao emp = (Qudao) o;
			return emp.istj-this.istj;
		}
		return 0;

	}

	@Override
	public String toString() {
		return "Qudao [id=" + id + ", user=" + user + ", leixing=" + leixing
				+ ", xitong=" + xitong + ", liangji=" + liangji + ", qq=" + qq
				+ ", weixin=" + weixin + ", phone=" + phone + ", lianjie="
				+ lianjie + ", content=" + content + ", title=" + title
				+ ", huifunum=" + huifunum + ", shijian=" + shijian
				+ ", dengji=" + dengji + ", isok=" + isok + ", istj=" + istj
				+ "]";
	}
	
	

}