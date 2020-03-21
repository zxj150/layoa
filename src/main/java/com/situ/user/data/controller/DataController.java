package com.situ.user.data.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.user.data.domain.Data;
import com.situ.user.data.service.DataService;
import com.situ.user.role.domain.LayResult;
import com.situ.user.role.domain.User;
@RestController
@RequestMapping("data")
public class DataController implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Autowired
	private DataService dataService;
	/**
	 * @Title: goIndex
	 * @Description:(进体温数据首页)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/datalist")
	public ModelAndView godatalist(ModelAndView modelAndView) {
		modelAndView.setViewName("data/data_list");
		return modelAndView;
	}
	
	/**
	 * 分页查看
	 * @param page
	 * @param limit
	 * @param searchUser
	 * @return
	 */
	@GetMapping("/{page}/{limit}")
	public LayResult findUserByPage(@PathVariable Integer page, @PathVariable Integer limit, Data searchData,HttpServletRequest request) {
		return dataService.findDataByPage(page, limit, searchData,request);
	}
	/**
	 * 删除
	 * @param rowId
	 * @return
	 */
	@DeleteMapping("/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return dataService.deletedata(rowId);
	}
	/**
	 * @Title: getForm
	 * @Description:(得到表单)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.setViewName("data/data_add");
		return modelAndView;
	}
	/**
	 * 体温新增
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping
	public Long saveuser(Data data,HttpServletRequest request) {
		return dataService.save(data, request);
	}
}
