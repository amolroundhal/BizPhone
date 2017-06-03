package com.softtantra.bizphone.ws;

import java.util.HashMap;
import java.util.Map;

public class AjaxResponse {
	String status;
	String msg;
	Map<String,Object> data = new HashMap<String,Object>();
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
