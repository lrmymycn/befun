package com.befun.dao.profile.impl;

import org.springframework.stereotype.Repository;

import com.befun.dao.BaseHibernateDao;
import com.befun.dao.profile.ClientRequirementDao;
import com.befun.domain.profile.ClientRequirement;

@Repository("ClientRequirementDao")
public class ClientRequirementDaoImpl extends BaseHibernateDao<ClientRequirement, Long> implements ClientRequirementDao {

}
