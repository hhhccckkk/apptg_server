package com.hck.apptg.bean;

/**
 * Version entity. @author MyEclipse Persistence Tools
 */

public class Version implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer versioncode;
	private String downurl;
	private String info;

	// Constructors

	/** default constructor */
	public Version() {
	}

	/** minimal constructor */
	public Version(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Version(Integer id, Integer versioncode, String downurl, String info) {
		this.id = id;
		this.versioncode = versioncode;
		this.downurl = downurl;
		this.info = info;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersioncode() {
		return this.versioncode;
	}

	public void setVersioncode(Integer versioncode) {
		this.versioncode = versioncode;
	}

	public String getDownurl() {
		return this.downurl;
	}

	public void setDownurl(String downurl) {
		this.downurl = downurl;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}