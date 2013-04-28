package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.ApartmentDao;
import com.befun.domain.estate.Apartment;

@Repository("ApartmentDao")
public class ApartmentDaoImpl extends BaseHibernateDao<Apartment, Long> implements ApartmentDao {

}
