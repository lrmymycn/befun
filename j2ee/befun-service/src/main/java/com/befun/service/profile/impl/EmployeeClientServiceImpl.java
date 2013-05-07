package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.EmployeeClient;
import com.befun.service.BaseService;
import com.befun.service.profile.EmployeeClientService;

@Service("EmployeeClientService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class EmployeeClientServiceImpl extends BaseService<EmployeeClient, Long> implements EmployeeClientService {

    @Resource
    public void setDao(@Qualifier("EmployeeClientDao") IBaseDao<EmployeeClient, Long> dao) {
        this.dao = dao;
    }

}
