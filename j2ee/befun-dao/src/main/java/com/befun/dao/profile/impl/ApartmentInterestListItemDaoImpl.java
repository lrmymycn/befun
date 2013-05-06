package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ApartmentInterestListItemDao;
import com.befun.domain.profile.ApartmentInterestListItem;

@Repository("ApartmentInterestListItemDao")
public class ApartmentInterestListItemDaoImpl extends BaseHibernateDao<ApartmentInterestListItem, Long> implements ApartmentInterestListItemDao {

}
