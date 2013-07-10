package com.befun.service.estate.impl;

import java.util.HashMap;
import java.util.Map;

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

    private static final String DELETE_BY_PROJECT_ID = "delete from com.befun.domain.estate.ProjectMedia pm where pm.project.id = :projectId";

    private static final String DELETE_BY_PROJECT_BID = "delete from com.befun.domain.estate.ProjectMedia pm left join pm.project p where p.bid = :projectBid";

    @Override
    @Resource
    public void setDao(@Qualifier("ProjectMediaDao") IBaseDao<ProjectMedia, Long> dao) {
        this.dao = dao;
    }

    public void removeMediasOfProject(long projectId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("projectId", projectId);
        this.dao.execute(DELETE_BY_PROJECT_ID, paramMap);
    }

    public void removeMediasOfProject(String projectBid) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("projectBid", projectBid);
        this.dao.execute(DELETE_BY_PROJECT_BID, paramMap);
    }
}
