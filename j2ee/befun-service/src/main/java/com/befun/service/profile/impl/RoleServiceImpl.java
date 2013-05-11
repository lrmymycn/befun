package com.befun.service.profile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Role;
import com.befun.domain.profile.RoleCode;
import com.befun.service.BaseService;
import com.befun.service.profile.RoleService;

@Service("RoleService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class RoleServiceImpl extends BaseService<Role, Long> implements RoleService {

    @Resource
    public void setDao(@Qualifier("RoleDao") IBaseDao<Role, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<Role> queryRoleByCodes(RoleCode... codes) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("codes", codes);
        List<Role> rs = this.dao.query("from com.befun.domain.profile.Role r where r.code in :codes", paramMap);
        return rs;
    }

}
