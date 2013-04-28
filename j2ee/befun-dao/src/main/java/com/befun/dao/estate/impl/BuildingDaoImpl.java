package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.BuildingDao;
import com.befun.domain.estate.Building;

@Repository("BuildingDao")
public class BuildingDaoImpl extends BaseHibernateDao<Building, Long> implements BuildingDao {

}
