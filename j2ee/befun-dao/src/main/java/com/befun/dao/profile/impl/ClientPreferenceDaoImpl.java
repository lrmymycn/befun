package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ClientPreferenceDao;
import com.befun.domain.profile.ClientPreference;

@Repository("ClientPreferenceDao")
public class ClientPreferenceDaoImpl extends BaseHibernateDao<ClientPreference, Long> implements ClientPreferenceDao {

}
