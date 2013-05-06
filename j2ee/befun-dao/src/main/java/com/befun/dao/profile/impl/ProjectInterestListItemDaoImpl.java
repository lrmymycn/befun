package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ProjectInterestListItemDao;
import com.befun.domain.profile.ProjectInterestListItem;

@Repository("ProjectInterestListItemDao")
public class ProjectInterestListItemDaoImpl extends BaseHibernateDao<ProjectInterestListItem, Long> implements ProjectInterestListItemDao {

}
