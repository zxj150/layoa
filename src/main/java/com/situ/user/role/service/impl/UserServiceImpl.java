package com.situ.user.role.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.user.role.dao.UserDao;
import com.situ.user.role.domain.LayResult;
import com.situ.user.role.domain.User;
import com.situ.user.role.service.UserService;
import com.situ.user.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Long save(User user) {
		user.setUserPass(MD5Utils.encode(user.getUserPass()));
		user.setActiveFlag(1);
		user.setCreateBy("zxj");
		user.setCreateDate(new Date());
		user.setUserKind(1);
		userDao.save(user);
		return user.getRowId();
	}

	@Override
	public Integer findByUserCode(String userCode) {
		Integer result = 0;
		User user = userDao.findByUserCode(userCode);
		if (user != null) {
			result = 1;
		}
		return result;
	}

	@Override
	public LayResult doUserLogin(User loginUserParam, HttpSession session) {
		Integer code = 0;
		String msg = "";
		String userCode = loginUserParam.getUserCode();
		String userPass = loginUserParam.getUserPass();
		User loginUser = userDao.findByCodeAndPass(userCode, MD5Utils.encode(userPass));
		if (loginUser != null) {
			code=1;
			session.setAttribute("user_return", loginUser);
		} else {
			msg = "用户名或密码错误!";
		}
		return new LayResult(code, msg, null);
	}

}
