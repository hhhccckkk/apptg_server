package com.hck.apptg.bean;

import java.sql.Timestamp;

/**
 * Jinbi entity. @author MyEclipse Persistence Tools
 */

public class Jinbi implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer jifen;
	private Timestamp shijian;
	private Integer jinbi;
	private Long uid;

	// Constructors

	/** default constructor */
	public Jinbi() {
	}

	/** full constructor */
	public Jinbi(Integer jifen, Timestamp shijian, Integer jinbi, Long uid) {
		this.jifen = jifen;
		this.shijian = shijian;
		this.jinbi = jinbi;
		this.uid = uid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getJifen() {
		return this.jifen;
	}

	public void setJifen(Integer jifen) {
		this.jifen = jifen;
	}

	public Timestamp getShijian() {
		return this.shijian;
	}

	public void setShijian(Timestamp shijian) {
		this.shijian = shijian;
	}

	public Integer getJinbi() {
		return this.jinbi;
	}

	public void setJinbi(Integer jinbi) {
		this.jinbi = jinbi;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}