package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.FloorplanDao;
import com.befun.domain.estate.Floorplan;

@Repository("FloorplanDao")
public class FloorplanDaoImpl extends BaseHibernateDao<Floorplan, Long> implements FloorplanDao {

}
