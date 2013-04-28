package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.AreaCommentDao;
import com.befun.domain.community.AreaComment;

@Repository("AreaCommentDao")
public class AreaCommentDaoImpl extends BaseHibernateDao<AreaComment, Long> implements AreaCommentDao {

}
