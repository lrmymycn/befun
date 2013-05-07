package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Role;
import com.befun.service.BaseService;
import com.befun.service.profile.RoleService;

@Service("RoleService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class RoleServiceImpl extends BaseService<Role, Long> implements RoleService {

    @Resource
    public void setDao(@Qualifier("RoleDao") IBaseDao<Role, Long> dao) {
        this.dao = dao;
    }

}
