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
import com.befun.domain.profile.ProfileRole;
import com.befun.service.BaseService;
import com.befun.service.profile.ProfileRoleService;

@Service("ProfileRoleService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ProfileRoleServiceImpl extends BaseService<ProfileRole, Long> implements ProfileRoleService {

    private static final String hql = "from com.befun.domain.profile.ProfileRole pr where pr.profile.id = :profileId";

    @Resource
    public void setDao(@Qualifier("ProfileRoleDao") IBaseDao<ProfileRole, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<ProfileRole> queryRolesByProfileId(Long profileId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("profileId", profileId);
        List<ProfileRole> rs = this.dao.query(hql, paramMap);
        return rs;
    }

}
