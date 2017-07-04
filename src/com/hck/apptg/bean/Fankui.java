package com.hck.apptg.bean;

/**
 * Fankui entity. @author MyEclipse Persistence Tools
 */

public class Fankui implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private String content;
	private String shijian;
	private Long uid;

	// Constructors

	/** default constructor */
	public Fankui() {
	}

	/** full constructor */
	public Fankui(String title, String content, String shijian, Long uid) {
		this.title = title;
		this.content = content;
		this.shijian = shijian;
		this.uid = uid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getShijian() {
		return this.shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}