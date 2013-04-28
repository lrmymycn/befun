package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Stage;
import com.befun.service.estate.StageService;

@Service("StageService")
@Transactional(rollbackFor = Exception.class)
public class StageServiceImpl extends BaseEstateServiceImpl<Stage, Long> implements StageService {

    @Override
    @Resource
    public void setDao(@Qualifier("StageDao") IBaseDao<Stage, Long> dao) {
        this.dao = dao;
    }

}
