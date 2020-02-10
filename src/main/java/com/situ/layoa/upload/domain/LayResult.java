package com.situ.layoa.upload.domain;

import java.io.Serializable;


public class LayResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private String msg;
	private Object data;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LayResult(Integer code, String msg,  Integer count,Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
		
	}

	public LayResult(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
