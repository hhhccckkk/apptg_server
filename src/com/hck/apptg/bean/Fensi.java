package com.hck.apptg.bean;

/**
 * Fensi entity. @author MyEclipse Persistence Tools
 */

public class Fensi implements java.io.Serializable {

	// Fields

	private Long id;
	private Long uid;
	private Long fuid;
	private String ftouxiang;
	private String fname;
	private String time;
	private String touxiang;
	private String name;

	// Constructors

	/** default constructor */
	public Fensi() {
	}

	/** full constructor */
	public Fensi(Long uid, Long fuid, String ftouxiang, String fname,
			String time, String touxiang, String name) {
		this.uid = uid;
		this.fuid = fuid;
		this.ftouxiang = ftouxiang;
		this.fname = fname;
		this.time = time;
		this.touxiang = touxiang;
		this.name = name;
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

	public String getFtouxiang() {
		return this.ftouxiang;
	}

	public void setFtouxiang(String ftouxiang) {
		this.ftouxiang = ftouxiang;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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

}