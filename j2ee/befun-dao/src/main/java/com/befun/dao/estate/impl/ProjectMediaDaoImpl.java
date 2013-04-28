package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.ProjectMediaDao;
import com.befun.domain.estate.ProjectMedia;

@Repository("ProjectMediaDao")
public class ProjectMediaDaoImpl extends BaseHibernateDao<ProjectMedia, Long> implements ProjectMediaDao {

}
