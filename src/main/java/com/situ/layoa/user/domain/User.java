package com.situ.layoa.user.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private Integer UserAge;
	private Integer userSex;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirth;
	private Integer userLike;
	private String userImg;
	
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return UserAge;
	}
	public void setUserAge(Integer userAge) {
		UserAge = userAge;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public Integer getUserLike() {
		return userLike;
	}
	public void setUserLike(Integer userLike) {
		this.userLike = userLike;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", UserAge=" + UserAge + ", userSex=" + userSex + ", userBirth="
				+ userBirth + ", userLike=" + userLike + ", userImg=" + userImg + "]";
	}
	

}
