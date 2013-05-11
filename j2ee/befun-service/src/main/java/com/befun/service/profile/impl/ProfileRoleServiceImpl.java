package com.befun.service.profile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.dao.profile.ProfileDao;
import com.befun.dao.profile.RoleDao;
import com.befun.domain.profile.Profile;
import com.befun.domain.profile.ProfileRole;
import com.befun.domain.profile.Role;
import com.befun.service.BaseService;
import com.befun.service.profile.ProfileRoleService;

@Service("ProfileRoleService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ProfileRoleServiceImpl extends BaseService<ProfileRole, Long> implements ProfileRoleService {

    private static final String HQL_QUERYROLES_BYPROFILE = "from com.befun.domain.profile.ProfileRole pr where pr.profile.id = :profileId";

    @Resource
    @Qualifier("ProfileDao")
    private ProfileDao profileDao;

    @Resource
    @Qualifier("RoleDao")
    private RoleDao roleDao;

    @Resource
    public void setDao(@Qualifier("ProfileRoleDao") IBaseDao<ProfileRole, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<ProfileRole> queryRolesByProfileId(Long profileId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("profileId", profileId);
        List<ProfileRole> rs = this.dao.query(HQL_QUERYROLES_BYPROFILE, paramMap);
        return rs;
    }

    @Override
    public void deleteRolesByProfileId(Long profileId) {
        List<ProfileRole> prs = this.queryRolesByProfileId(profileId);
        if (prs == null || prs.isEmpty()) {
            return;
        }
        for (ProfileRole pr : prs) {
            this.dao.deleteObject(pr);
        }
    }

    @Override
    public void refreshProfileRoles(Long profileId, List<Long> roleIds) {
        Assert.notNull(profileId, "profileId should be not null!");
        Assert.notNull(roleIds, "roleIds should be not null!");
        Profile profile = this.profileDao.get(profileId);
        if (profile == null) {
            return;
        }
        this.deleteRolesByProfileId(profileId);
        ProfileRole pr = null;
        for (Long roleId : roleIds) {
            pr = new ProfileRole();
            pr.setProfile(profile);
            Role role = this.roleDao.get(roleId);
            if (role == null) {
                continue;
            }
            pr.setRole(role);
            this.dao.save(pr);
        }
    }

}
