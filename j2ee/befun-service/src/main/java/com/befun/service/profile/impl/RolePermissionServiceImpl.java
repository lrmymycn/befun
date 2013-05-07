package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.RolePermission;
import com.befun.service.BaseService;
import com.befun.service.profile.RolePermissionService;

@Service("RolePermissionService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class RolePermissionServiceImpl extends BaseService<RolePermission, Long> implements RolePermissionService {

    @Resource
    public void setDao(@Qualifier("RolePermissionDao") IBaseDao<RolePermission, Long> dao) {
        this.dao = dao;
    }

}
