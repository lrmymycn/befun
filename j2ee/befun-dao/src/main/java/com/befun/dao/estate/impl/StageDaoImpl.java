package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.StageDao;
import com.befun.domain.estate.Stage;

@Repository("StageDao")
public class StageDaoImpl extends BaseHibernateDao<Stage, Long> implements StageDao {

}
