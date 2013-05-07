package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Client;
import com.befun.service.BaseService;
import com.befun.service.profile.ClientService;

@Service("ClientService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ClientServiceImpl extends BaseService<Client, Long> implements ClientService {

    @Resource
    public void setDao(@Qualifier("ClientDao") IBaseDao<Client, Long> dao) {
        this.dao = dao;
    }

}
