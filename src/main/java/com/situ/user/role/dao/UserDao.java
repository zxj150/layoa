package com.situ.user.role.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.user.role.domain.User;

@Repository
public interface UserDao extends BaseDao<User>{

	User findByCodeAndPass(@Param("userCode")String userCode,@Param("userPass") String userPass);

	User findByUserCode(@Param("userCode")String userCode);
}
