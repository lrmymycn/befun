package com.befun.service.estate.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Area;
import com.befun.service.estate.AreaService;
import com.befun.service.query.AreaQueryCondition;

@Service("AreaService")
@Transactional(rollbackFor = Exception.class)
public class AreaServiceImpl extends BaseEstateServiceImpl<Area, Long> implements AreaService {

    @Override
    @Resource
    public void setDao(@Qualifier("AreaDao") IBaseDao<Area, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<Area> queryByName(String name) {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        queryCondition.setName(name);
        List<Area> rs = this.dao.query(queryCondition);
        return rs;
    }

}
