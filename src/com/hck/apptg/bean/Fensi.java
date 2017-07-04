package com.hck.apptg.bean;

/**
 * Fensi entity. @author MyEclipse Persistence Tools
 */

public class Fensi implements java.io.Serializable {

	// Fields

	private Long id;
	private Long uid;
	private Long fuid;
	private String touxiang;
	private String name;
	private String time;

	// Constructors

	/** default constructor */
	public Fensi() {
	}

	/** full constructor */
	public Fensi(Long uid, Long fuid, String touxiang, String name, String time) {
		this.uid = uid;
		this.fuid = fuid;
		this.touxiang = touxiang;
		this.name = name;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getFuid() {
		return this.fuid;
	}

	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}

	public String getTouxiang() {
		return this.touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}