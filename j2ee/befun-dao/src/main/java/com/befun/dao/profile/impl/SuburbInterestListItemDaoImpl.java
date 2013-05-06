package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.SuburbInterestListItemDao;
import com.befun.domain.profile.SuburbInterestListItem;

@Repository("SuburbInterestListItemDao")
public class SuburbInterestListItemDaoImpl extends BaseHibernateDao<SuburbInterestListItem, Long> implements SuburbInterestListItemDao {

}
