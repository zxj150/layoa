package com.situ.layoa.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
import com.situ.layoa.upload.domain.LayResult;
import com.situ.layoa.utils.DAOUtils;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Long save(Role role) {
		 roleDao.save(role);
		 return role.getRowId();
	}

	@Override
	public Integer findByRoleName(String roleName) {

		Integer result = 0;
		Role role = roleDao.findByRoleName(roleName);
		if (role != null) {
			result = 1;
		}
		return result;
	}

	@Override
	public List<Role> find() {
		 return roleDao.find();
	}

	@Override
	public Integer getCount(Role searchRole) {
		return roleDao.getCount(searchRole);
	}

	@Override
	public Role findRoleById(Long rowId) {
		return roleDao.get(rowId);
	}

	@Override
	public Long deleteRole(Long rowId) {
		 roleDao.delete(rowId);
		 return 1L;
	}

	@Override
	public Long doUpdate(Role role) {
		Long rowId=role.getRowId();
		Role editRole=roleDao.get(rowId);
		 roleDao.update(DAOUtils.buildEditData(editRole, role));
		 return 1L;
	}

	/**
	 * 分页查询
	 */
	@Override
	public LayResult findRoleByPage(Integer page, Integer limit, Role searchRole) {
		Role searchParam=DAOUtils.buildSearchParam(searchRole);
		//查询出符合条件的一共有多少条记录。
		Integer dataCount=roleDao.getCount(searchParam);
		List<Role> roleList=roleDao.findByPage(DAOUtils.buildPagination(page, limit),searchParam);
		return new LayResult(0,"",dataCount,roleList);
	}

}
