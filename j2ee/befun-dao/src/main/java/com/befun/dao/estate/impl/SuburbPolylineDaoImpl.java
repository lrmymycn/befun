package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.SuburbPolylineDao;
import com.befun.domain.estate.SuburbPolyline;

@Repository("SuburbPolylineDao")
public class SuburbPolylineDaoImpl extends BaseHibernateDao<SuburbPolyline, Long> implements SuburbPolylineDao {

}
