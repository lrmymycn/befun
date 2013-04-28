package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Building;
import com.befun.service.estate.BuildingService;

@Service("BuildingService")
@Transactional(rollbackFor = Exception.class)
public class BuildingServiceImpl extends BaseEstateServiceImpl<Building, Long> implements BuildingService {

    @Override
    @Resource
    public void setDao(@Qualifier("BuildingDao") IBaseDao<Building, Long> dao) {
        this.dao = dao;
    }

}
