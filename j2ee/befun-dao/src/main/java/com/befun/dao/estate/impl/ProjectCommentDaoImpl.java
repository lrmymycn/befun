package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.ProjectCommentDao;
import com.befun.domain.community.ProjectComment;

@Repository("ProjectCommentDao")
public class ProjectCommentDaoImpl extends BaseHibernateDao<ProjectComment, Long> implements ProjectCommentDao {

}
