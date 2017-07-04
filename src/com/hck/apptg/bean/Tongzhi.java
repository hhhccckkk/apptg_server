package com.hck.apptg.bean;

/**
 * Tongzhi entity. @author MyEclipse Persistence Tools
 */

public class Tongzhi implements java.io.Serializable {

	// Fields

	private Long id;
	private String content;
	private String shijian;
	private Long uid;
	private Long huid;
	private String title;
	private Integer type;

	// Constructors

	/** default constructor */
	public Tongzhi() {
	}

	/** full constructor */
	public Tongzhi(String content, String shijian, Long uid, Long huid,
			String title, Integer type) {
		this.content = content;
		this.shijian = shijian;
		this.uid = uid;
		this.huid = huid;
		this.title = title;
		this.type = type;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getHuid() {
		return this.huid;
	}

	public void setHuid(Long huid) {
		this.huid = huid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}