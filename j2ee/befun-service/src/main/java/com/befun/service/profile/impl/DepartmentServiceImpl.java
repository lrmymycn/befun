package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Department;
import com.befun.service.BaseService;
import com.befun.service.profile.DepartmentService;

@Service("DepartmentService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class DepartmentServiceImpl extends BaseService<Department, Long> implements DepartmentService {

    @Resource
    public void setDao(@Qualifier("DepartmentDao") IBaseDao<Department, Long> dao) {
        this.dao = dao;
    }

}
