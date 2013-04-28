package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Floorplan;
import com.befun.service.estate.FloorplanService;

@Service("FloorplanService")
@Transactional(rollbackFor = Exception.class)
public class FloorplanServiceImpl extends BaseEstateServiceImpl<Floorplan, Long> implements FloorplanService {

    @Override
    @Resource
    public void setDao(@Qualifier("FloorplanDao") IBaseDao<Floorplan, Long> dao) {
        this.dao = dao;
    }

}
