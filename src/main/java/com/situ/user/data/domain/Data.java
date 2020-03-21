package com.situ.user.data.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.user.role.domain.BaseClass;
@Alias("Data")
public class Data extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;//用户名称
	private String data1;//体温数据
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	
}
