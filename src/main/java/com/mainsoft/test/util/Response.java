package com.mainsoft.test.util;

import java.util.HashMap;
import java.util.Map;

public class Response {
	
	private int code;
	private String message;
	private Map<String, Object> data;
	
	public Response() {}

	public Response(int code, String message) {
		this.code = code;
		this.message = message;
		this.data = new HashMap<>();
	}
	
	public void setDataPair(String key, Object value) {
		if (this.data == null) {
			this.data = new HashMap<>();
		}
		
		this.data.put(key, value);
	}
	
	public Response(ResponseStatusEnum responseStatusEnum) {
		this.code = responseStatusEnum.getCode();
		this.message = responseStatusEnum.getDescription();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
