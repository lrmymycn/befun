package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.CommentDao;
import com.befun.domain.community.Comment;

@Repository("CommentDao")
public class CommentDaoImpl extends BaseHibernateDao<Comment, Long> implements CommentDao {

}
