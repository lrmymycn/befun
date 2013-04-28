package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.FloorplanCommentDao;
import com.befun.domain.community.FloorplanComment;

@Repository("FloorplanCommentDao")
public class FloorplanCommentDaoImpl extends BaseHibernateDao<FloorplanComment, Long> implements FloorplanCommentDao {

}
