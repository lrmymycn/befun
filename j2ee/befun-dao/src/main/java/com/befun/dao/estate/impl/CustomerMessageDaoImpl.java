package com.befun.dao.estate.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.estate.CustomerMessageDao;
import com.befun.domain.community.CustomerMessage;

@Repository("CustomerMessageDao")
public class CustomerMessageDaoImpl extends BaseHibernateDao<CustomerMessage, Long> implements CustomerMessageDao {

}
