package com.hck.apptg.vo;

import com.hck.apptg.bean.Qudao;

public class TieZi extends QudaoData{
  private long uid;
  private int type;
  private long tid;
  private String title;
  private String time;

public long getUid() {
	return uid;
}
public void setUid(long uid) {
	this.uid = uid;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public long getTid() {
	return tid;
}
public void setTid(long tid) {
	this.tid = tid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
  
}
