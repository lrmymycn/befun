package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.AreaPolylineDao;
import com.befun.domain.estate.AreaPolyline;

@Repository("AreaPolylineDao")
public class AreaPolylineDaoImpl extends BaseHibernateDao<AreaPolyline, Long> implements AreaPolylineDao {

}
