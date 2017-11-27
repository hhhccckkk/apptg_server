package com.hck.apptg.bean;

/**
 * Jubao entity. @author MyEclipse Persistence Tools
 */

public class Jubao implements java.io.Serializable {

	private Long id;
	private Long uid;
	private Long buid;
	private String bname;
	private String bcontent;
	private String btime;
    private long tid;
    
	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

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

	public Long getBuid() {
		return this.buid;
	}

	public void setBuid(Long buid) {
		this.buid = buid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBcontent() {
		return this.bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBtime() {
		return this.btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

}