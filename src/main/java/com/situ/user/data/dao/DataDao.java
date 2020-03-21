package com.situ.user.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.user.data.domain.Data;
import com.situ.user.role.dao.BaseDao;
import com.situ.user.role.domain.Pagination;

@Repository
public interface DataDao extends BaseDao<Data>{

	Integer getCount2(@Param("searchParam") Data searchParam);

	List<Data> findByPage2(@Param("pagination") Pagination pagination,@Param("searchParam") Data searchParam,@Param("userName") String userName);

}
