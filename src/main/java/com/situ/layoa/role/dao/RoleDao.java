package com.situ.layoa.role.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.layoa.role.domain.Role;


@Repository
public interface RoleDao {
	Long add(Role role);
	
	Role findByRoleName(@Param("roleName")String roleName);
}
