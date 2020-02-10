package com.situ.layoa.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.layoa.role.domain.Pagination;

public interface BaseDao<T> {

	void save(T t);

	void update(T t);

	void delete(Long rowId);

	T get(Long rowId);

	List<T> find();

	Integer getCount(@Param("searchParam") T t);

	List<T> findByPage(@Param("pagination") Pagination pagination, @Param("searchParam") T t);
}
