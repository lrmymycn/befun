package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.community.Comment;
import com.befun.service.BaseService;
import com.befun.service.estate.CommentService;

@Service("CommentService")
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl extends BaseService<Comment, Long> implements CommentService {

    @Override
    @Resource
    public void setDao(@Qualifier("CommentDao") IBaseDao<Comment, Long> dao) {
        this.dao = dao;
    }

    @Override
    public Comment get(Long id) {
        Comment model = super.get(id);
        if (model != null) {
            model.getProfile().getDescription();
        }
        return model;
    }

}
