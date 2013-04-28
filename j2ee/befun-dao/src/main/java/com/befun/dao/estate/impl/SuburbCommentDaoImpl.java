package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.SuburbCommentDao;
import com.befun.domain.community.SuburbComment;

@Repository("SuburbCommentDao")
public class SuburbCommentDaoImpl extends BaseHibernateDao<SuburbComment, Long> implements SuburbCommentDao {

}
