package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.InterestListDao;
import com.befun.domain.profile.InterestList;

@Repository("InterestListDao")
public class InterestListDaoImpl extends BaseHibernateDao<InterestList, Long> implements InterestListDao {

}
