package com.situ.layoa.user.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.layoa.user.domain.User;

@RestController
@RequestMapping("/user")
public class UserController implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostMapping
	public Long save(User user) {
		System.out.println(user);
		return 1L;
	}
	
	@GetMapping("/checkname")
	public Integer doGet(String userName) {
		Integer result = 1;
		if ("zhangsan".equals(userName)) {
			result = 0;
		}
		return result;
	}

}
