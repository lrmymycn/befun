package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.SuburbDao;
import com.befun.domain.estate.Suburb;

@Repository("SuburbDao")
public class SuburbDaoImpl extends BaseHibernateDao<Suburb, Long> implements SuburbDao {

}
