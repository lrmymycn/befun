package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.community.FloorplanComment;
import com.befun.service.BaseService;
import com.befun.service.estate.FloorplanCommentService;

@Service("FloorplanCommentService")
@Transactional(rollbackFor = Exception.class)
public class FloorplanCommentServiceImpl extends BaseService<FloorplanComment, Long> implements FloorplanCommentService {

    @Override
    @Resource
    public void setDao(@Qualifier("FloorplanCommentDao") IBaseDao<FloorplanComment, Long> dao) {
        this.dao = dao;
    }

}
