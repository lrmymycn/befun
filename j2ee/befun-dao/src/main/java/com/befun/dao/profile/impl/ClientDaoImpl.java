package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ClientDao;
import com.befun.domain.profile.Client;

@Repository("ClientDao")
public class ClientDaoImpl extends BaseHibernateDao<Client, Long> implements ClientDao {

}
