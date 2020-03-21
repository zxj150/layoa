package com.situ.user.role.domain;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("User")
public class User extends BaseClass implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userCode;//用户账号
	private String userName;//用户名称
	private String userPass;//用户密码
	private Integer userAge;//用户性别 #0：女 1：男
	private String userCard;//用户身份证号
	private Integer userKind;//用户级别#0：超级用户 1：普通用户
	private String provinceCode;//省份code
	private String cityCode;//市code
	private String areaCode;//县（区）code
	private String userAddress;//详细地址
	
	@Override
	public String toString() {
		return "User [userCode=" + userCode + ", userName=" + userName + ", userPass=" + userPass + ", userAge="
				+ userAge + ", userCard=" + userCard + ", userKind=" + userKind + ", provinceCode=" + provinceCode
				+ ", cityCode=" + cityCode + ", areaCode=" + areaCode + ", userAddress=" + userAddress + "]";
	}
	public Integer getUserKind() {
		return userKind;
	}
	public void setUserKind(Integer userKind) {
		this.userKind = userKind;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserCard() {
		return userCard;
	}
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
