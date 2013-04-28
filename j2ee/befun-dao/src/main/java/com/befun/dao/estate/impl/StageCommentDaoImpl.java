package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.StageCommentDao;
import com.befun.domain.community.StageComment;

@Repository("StageCommentDao")
public class StageCommentDaoImpl extends BaseHibernateDao<StageComment, Long> implements StageCommentDao {

}
