package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Employee;
import com.befun.service.BaseService;
import com.befun.service.profile.EmployeeService;

@Service("EmployeeService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl extends BaseService<Employee, Long> implements EmployeeService {

    @Resource
    public void setDao(@Qualifier("EmployeeDao") IBaseDao<Employee, Long> dao) {
        this.dao = dao;
    }

}
