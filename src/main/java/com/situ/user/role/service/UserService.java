package com.situ.user.role.service;

import javax.servlet.http.HttpSession;

import com.situ.user.role.domain.LayResult;
import com.situ.user.role.domain.User;

public interface UserService {

	Long save(User user);

	LayResult doUserLogin(User loginUserParam, HttpSession session);

	Integer findByUserCode(String userCode);
}
