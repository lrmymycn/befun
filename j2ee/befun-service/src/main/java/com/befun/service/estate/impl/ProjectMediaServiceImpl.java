package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.ProjectMedia;
import com.befun.service.estate.ProjectMediaService;

@Service("ProjectMediaService")
@Transactional(rollbackFor = Exception.class)
public class ProjectMediaServiceImpl extends BaseEstateServiceImpl<ProjectMedia, Long> implements ProjectMediaService {

    @Override
    @Resource
    public void setDao(@Qualifier("ProjectMediaDao") IBaseDao<ProjectMedia, Long> dao) {
        this.dao = dao;
    }

}
