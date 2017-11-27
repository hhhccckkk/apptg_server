package com.hck.apptg.vo;

import com.hck.apptg.bean.Qudao;
import com.hck.apptg.bean.Ziyuan;


public class QudaoData implements java.io.Serializable {
	private Long id;
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
	private String name;
	private int sex;
	private String touxiang;
	private long jifeng;
	private long uid;
    private long fensi;
    private int istj;
    private String qqId;
    
	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public int getIstj() {
		return istj;
	}

	public void setIstj(int istj) {
		this.istj = istj;
	}

	public long getFensi() {
		return fensi;
	}

	public void setFensi(long fensi) {
		this.fensi = fensi;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTouxiang() {
		return touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public long getJifeng() {
		return jifeng;
	}

	public void setJifeng(long jifeng) {
		this.jifeng = jifeng;
	}

	
}