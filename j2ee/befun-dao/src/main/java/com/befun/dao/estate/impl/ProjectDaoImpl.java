package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.ProjectDao;
import com.befun.domain.estate.Project;

@Repository("ProjectDao")
public class ProjectDaoImpl extends BaseHibernateDao<Project, Long> implements ProjectDao {

}
