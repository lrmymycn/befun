package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.dao.common.IQueryCondition;
import com.befun.domain.PaginationBean;
import com.befun.domain.community.ProjectComment;
import com.befun.service.BaseService;
import com.befun.service.estate.ProjectCommentService;

@Service("ProjectCommentService")
@Transactional(rollbackFor = Exception.class)
public class ProjectCommentServiceImpl extends BaseService<ProjectComment, Long> implements ProjectCommentService {

    @Override
    @Resource
    public void setDao(@Qualifier("ProjectCommentDao") IBaseDao<ProjectComment, Long> dao) {
        this.dao = dao;
    }

    @Override
    public PaginationBean<ProjectComment> query(IQueryCondition queryCondition, long pageNumber, int pageSize) {
        PaginationBean<ProjectComment> pgb = this.dao.query(queryCondition, pageNumber, pageSize);
        for (ProjectComment c : pgb.getModels()) {
            c.getComment().getProfile().getUsername();
        }
        return pgb;
    }
}
