package com.situ.layoa.role.service;

import com.situ.layoa.role.domain.Role;

public interface RoleService {

	Long add(Role role);

	Integer findByRoleName(String roleName);
}
