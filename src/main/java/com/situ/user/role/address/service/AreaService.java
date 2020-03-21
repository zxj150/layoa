package com.situ.user.role.address.service;

import java.util.List;

import com.situ.user.role.address.domain.Area;

public interface AreaService {
   List<Area> findAll();
   List<Area> findByCode(Integer areaCode);
   String findName(Integer areaCode);
}
