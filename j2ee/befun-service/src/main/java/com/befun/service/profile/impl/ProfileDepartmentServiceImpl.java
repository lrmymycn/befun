package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.ProfileDepartment;
import com.befun.service.BaseService;
import com.befun.service.profile.ProfileDepartmentService;

@Service("ProfileDepartmentService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ProfileDepartmentServiceImpl extends BaseService<ProfileDepartment, Long> implements ProfileDepartmentService {

    @Resource
    public void setDao(@Qualifier("ProfileDepartmentDao") IBaseDao<ProfileDepartment, Long> dao) {
        this.dao = dao;
    }

}
