package com.situ.user.role.address.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.user.role.domain.BaseClass;

@Alias("Area")
public class Area extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
     private Integer areaCode;
     private String areaName;
     private Integer parentCode;
     private Integer areaRunk;
     private Integer hasChild;
     private Integer activeFlag;
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getParentCode() {
		return parentCode;
	}
	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}
	public Integer getAreaRunk() {
		return areaRunk;
	}
	public void setAreaRunk(Integer areaRunk) {
		this.areaRunk = areaRunk;
	}
	public Integer getHasChild() {
		return hasChild;
	}
	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}
	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}
	
     
     
}
