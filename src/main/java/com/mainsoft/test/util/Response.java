package com.mainsoft.test.util;

import java.util.HashMap;
import java.util.Map;

public class Response {
	
	private int status;
	private String reason;
	private Map<String, Object> data;
	
	public Response(int status, String reason) {
		this.status = status;
		this.reason = reason;
		this.data = new HashMap<>();
	}
	
	public void setDataPair(String key, Object value) {
		if (this.data == null) {
			this.data = new HashMap<>();
		}
		
		this.data.put(key, value);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
