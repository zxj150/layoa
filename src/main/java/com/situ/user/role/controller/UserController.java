package com.situ.user.role.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.user.role.address.domain.Area;
import com.situ.user.role.address.service.AreaService;
import com.situ.user.role.domain.LayResult;
import com.situ.user.role.domain.User;
import com.situ.user.role.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;

	@Autowired
	private AreaService areaSercive;

	/**
	 * @Title: goIndex
	 * @Description:(进体温数据首页)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/dataIndex")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("data/index");
		return modelAndView;
	}



	/**
	 * 根据code查询省市区
	 * 
	 * @param parentCode
	 * @return
	 */
	@GetMapping("/findByCode/{parentCode}")
	public List<Area> goUpdate(@PathVariable("parentCode") Integer parentCode) {
		return areaSercive.findByCode(parentCode);
	}
	/**
	 * 进登陆页面
	 * @param modelAndView
	 * @param request
	 * @return
	 */
	@RequestMapping("/gologin")
	public ModelAndView gologin(ModelAndView modelAndView) {
		modelAndView.setViewName("user_login");
		return modelAndView;
	}

	/**
	 * 用户登录
	 * 
	 * @param fieldId
	 * @param fieldValue
	 * @return
	 */
	@RequestMapping("/dologin")
	public LayResult doUserLogin(User loginUserParam, HttpSession session) {
		return userService.doUserLogin(loginUserParam, session);
	}
	/**
	 * 用户退出
	 * 
	 * @param fieldId
	 * @param fieldValue
	 * @return
	 */
	@RequestMapping("/dologinOut")
	public ModelAndView doUserLoginOut(ModelAndView modelAndView, HttpSession session) {
		session.removeAttribute("user_return");
		modelAndView.setViewName("user_login");
		return modelAndView;
	}
	/**
	 * 用户新增（注册）
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping
	public Long saveuser(User user) {
		System.out.println(user);
		return userService.save(user);
	}

	/**
	 * 用户名唯一性校验
	 * @param userName
	 * @return
	 */
	@GetMapping("/checkname")
	public Integer checkuserName(String userCode) {
		return userService.findByUserCode(userCode);

	}

	/**
	 * @Title: getForm
	 * @Description:(得到表单)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.addObject("areaList", areaSercive.findAll());
		modelAndView.setViewName("user/user_add_edit");
		return modelAndView;
	}


}
