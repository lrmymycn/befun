package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.FloorplanInterestListItemDao;
import com.befun.domain.profile.FloorplanInterestListItem;

@Repository("FloorplanInterestListItemDao")
public class FloorplanInterestListItemDaoImpl extends BaseHibernateDao<FloorplanInterestListItem, Long> implements FloorplanInterestListItemDao {

}
