package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.AreaDao;
import com.befun.domain.estate.Area;

@Repository("AreaDao")
public class AreaDaoImpl extends BaseHibernateDao<Area, Long> implements AreaDao {

}
