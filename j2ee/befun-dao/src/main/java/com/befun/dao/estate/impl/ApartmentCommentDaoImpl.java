package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.ApartmentCommentDao;
import com.befun.domain.community.ApartmentComment;

@Repository("ApartmentCommentDao")
public class ApartmentCommentDaoImpl extends BaseHibernateDao<ApartmentComment, Long> implements ApartmentCommentDao {

}
