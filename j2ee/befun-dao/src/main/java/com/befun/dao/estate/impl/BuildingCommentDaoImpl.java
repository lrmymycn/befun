package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.BuildingCommentDao;
import com.befun.domain.community.BuildingComment;

@Repository("BuildingCommentDao")
public class BuildingCommentDaoImpl extends BaseHibernateDao<BuildingComment, Long> implements BuildingCommentDao {

}
