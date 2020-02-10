package com.situ.layoa.role.domain;

import java.io.Serializable;

public class Pagination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer firstResult;//分页开始的下标
	private Integer maxResults;//分页查询的数量
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
	public Pagination(Integer firstResult, Integer maxResults) {
		super();
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

}
