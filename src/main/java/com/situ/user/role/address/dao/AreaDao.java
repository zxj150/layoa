package com.situ.user.role.address.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.user.role.address.domain.Area;



@Repository
public interface AreaDao {
   List<Area> find();
   List<Area> findByCode(Integer areaCode);
   String findName(Integer areaCode);
}
