package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.ClientPreference;
import com.befun.service.BaseService;
import com.befun.service.profile.ClientPreferenceService;

@Service("ClientPreferenceService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ClientPreferenceServiceImpl extends BaseService<ClientPreference, Long> implements ClientPreferenceService {

    @Resource
    public void setDao(@Qualifier("ClientPreferenceDao") IBaseDao<ClientPreference, Long> dao) {
        this.dao = dao;
    }

}
