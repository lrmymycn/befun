package com.befun.service.estate;

import java.util.List;

import com.befun.domain.estate.Area;

public interface AreaService extends BaseEstateService<Area, Long> {

    List<Area> queryByName(String name);
}
