package com.situ.user.data.service;

import javax.servlet.http.HttpServletRequest;
import com.situ.user.data.domain.Data;
import com.situ.user.role.domain.LayResult;

public interface DataService {


	Long deletedata(Long rowId);

	Long save(Data data,HttpServletRequest request);

	LayResult findDataByPage(Integer page, Integer limit, Data searchData, HttpServletRequest request);

	Integer getCount(Data searchData);

}
