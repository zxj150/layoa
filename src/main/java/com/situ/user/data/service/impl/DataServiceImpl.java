package com.situ.user.data.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.user.data.dao.DataDao;
import com.situ.user.data.domain.Data;
import com.situ.user.data.service.DataService;
import com.situ.user.role.domain.LayResult;
import com.situ.user.role.domain.User;
import com.situ.user.utils.DAOUtils;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataDao dataDao;
	
	/**
	 * @Title: getCount
	 * @Description:(查询出数据的数量)
	 * @return
	 */
	@Override
	public Integer getCount(Data searchData) {
		return dataDao.getCount(searchData);
	}
	/**
	 * 分页查询
	 */
	@Override
	public LayResult findDataByPage(Integer page, Integer limit, Data searchData,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user_return");
		Integer userKind=user.getUserKind();
		Integer dataCount=null;
		List<Data> userList=null;
		if(userKind==0) {
		// 通过反射机制将类的实例中的""重新赋值为null,方便MyBatis中多条件查询SQL语句的拼写
		Data searchParam = DAOUtils.buildSearchParam(searchData);
		// 查询出符合条件的一共有多少条记录。
		dataCount = dataDao.getCount(searchParam);
		// 根据分页的请求信息查询出数量列表。
		userList = dataDao.findByPage(DAOUtils.buildPagination(page, limit), searchParam);
		}else {
			Data searchParam = DAOUtils.buildSearchParam(searchData);
			dataCount = dataDao.getCount2(searchParam);
			userList = dataDao.findByPage2(DAOUtils.buildPagination(page, limit), searchParam,user.getUserName());
		}
		return new LayResult(0, "", dataCount, userList);
	}
	
	/**
	 * 体温数据删除
	 */
	@Override
	public Long deletedata(Long rowId) {
		dataDao.delete(rowId);
		return 1L;
	}
	@Override
	public Long save(Data data,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user_return");
		data.setUserName(user.getUserName());
		data.setActiveFlag(1);
		data.setCreateDate(new Date());
		dataDao.save(data);
		return 1L;
	}
}
