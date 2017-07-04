package com.hck.apptg.bean;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private String content;
	private String shijian;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String title, String content, String shijian) {
		this.title = title;
		this.content = content;
		this.shijian = shijian;
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

}