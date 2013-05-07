package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Permission;
import com.befun.service.BaseService;
import com.befun.service.profile.PermissionService;

@Service("PermissionService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class PermissionServiceImpl extends BaseService<Permission, Long> implements PermissionService {

    @Resource
    public void setDao(@Qualifier("PermissionDao") IBaseDao<Permission, Long> dao) {
        this.dao = dao;
    }

}
