package com.situ.user.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.user.role.domain.User;

@Controller
public class IndexController {
	/**
	 * 用户状态判断
	 * @param modelAndView
	 * @param request
	 * @return
	 */
	@RequestMapping(path={"/index","/"})
	public ModelAndView goIndex(ModelAndView modelAndView,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user_return");
		//如果在登录状态则进入页面
		if(user!=null) {
			modelAndView.addObject("user_return", user);
			modelAndView.setViewName("data/index");
		}else {//否则进登陆页面
		modelAndView.setViewName("user_login");
		}
		return modelAndView;
	}
}
