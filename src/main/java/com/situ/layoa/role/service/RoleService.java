package com.situ.layoa.role.service;

import java.util.List;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.upload.domain.LayResult;

public interface RoleService {

	Long save(Role role);

	Integer findByRoleName(String roleName);

	List<Role> find();

	Integer getCount(Role searchRole);

	Role findRoleById(Long rowId);

	Long deleteRole(Long rowId);

	Long doUpdate(Role role);

	LayResult findRoleByPage(Integer page, Integer limit, Role searchRole);
}
