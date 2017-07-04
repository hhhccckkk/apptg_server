package com.hck.apptg.phone.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

public class BaseAction {
	public String password;
	public JSONObject json;
	public String jsonString;
	public HttpServletRequest request = null;
	public HttpServletResponse response = null;
	public int page;
	public long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void init() {
		json = new JSONObject();

		response = ServletActionContext.getResponse();

		request = ServletActionContext.getRequest();

		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

	}

	public void write() {

		jsonString = json.toString();
		OutputStream oStream = null;
		try {
			oStream = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			oStream.write(jsonString.getBytes("UTF-8"));
			oStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response = null;
		request = null;
		oStream = null;
	}

	public String getStringData(String key) {
		String dataString = request.getParameter(key);
		System.out.println("getStringData:" + key + ":" + dataString);
		return dataString;
	}

	public int getIntData(String key) {
		String dataString = getStringData(key);
		if (dataString == null || "null".equals(dataString)) {
			return 0;
		}
		int data = Integer.parseInt(getStringData(key));
		return data;
	}

	public long getLongData(String key) {
		String dataString = getStringData(key);
		if (dataString == null || "null".equals(dataString)) {
			return 0l;
		}
		long data = Long.parseLong(getStringData(key));
		return data;
	}

	public double getDoubleData(String key) {
		try {
			String dataString = getStringData(key);
			if (dataString == null || "".endsWith(dataString) || "null".equals(dataString)) {
				return 0;
			}
			double data = Double.parseDouble(getStringData(key));
			return data;
		} catch (Exception e) {
			System.out.println("eee: "+e);
			return 0;
		}
	}

}
