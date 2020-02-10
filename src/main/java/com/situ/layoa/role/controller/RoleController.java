package com.situ.layoa.role.controller;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
import com.situ.layoa.upload.domain.LayResult;
@RestController
@RequestMapping("/role")
public class RoleController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleService roleService;

	@PostMapping
	public Long saveRole(Role role) {
		System.out.println(role);
		return roleService.save(role);
	}

	@GetMapping("/checkname")
	public Integer checkRoleName(String roleName) {
		return roleService.findByRoleName(roleName);

	}
	@RequestMapping("/goadd")
	public ModelAndView goAdd(ModelAndView modelAndView) {
		modelAndView.setViewName("role/role_add_edit");
		return modelAndView;
	}
	@GetMapping("/find/{page}/{limit}")
	public LayResult findAll(@PathVariable Integer page,@PathVariable Integer limit,Role searchRole) {
		return roleService.findRoleByPage(page,limit,searchRole);
	}
	@GetMapping("/{rowId}")
	public Role goUpdate(@PathVariable Long rowId) {
		return roleService.findRoleById(rowId);
	}
	@PutMapping
	public Long doUpdateUser(Role role) {
		return this.roleService.doUpdate(role);
	}
	@DeleteMapping("/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return roleService.deleteRole(rowId);
	}
}
