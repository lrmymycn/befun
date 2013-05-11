package com.befun.service.profile.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientPreference;
import com.befun.domain.profile.Role;
import com.befun.domain.profile.RoleCode;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.ClientService;
import com.befun.service.profile.InterestListService;
import com.befun.service.profile.ProfileRoleService;
import com.befun.service.profile.RoleService;

@Service("ClientService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ClientServiceImpl extends BaseModificationService<Client, Long> implements ClientService {

    @Resource
    @Qualifier("ProfileRoleService")
    private ProfileRoleService profileRoleService;

    @Resource
    @Qualifier("RoleService")
    private RoleService roleService;

    @Resource
    @Qualifier("InterestListService")
    private InterestListService interestListService;

    @Resource
    public void setDao(@Qualifier("ClientDao") IBaseDao<Client, Long> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Client get(Long id) {
        Assert.notNull(id, "id should be not null!");
        Client c = dao.get(id);
        if (c == null) {
            return null;
        }
        if (c.getCurrentEmployee() != null) {
            c.getCurrentEmployee().getId();
        }
        return c;
    }

    @Override
    public Long save(Client model) {
        Assert.notNull(model, "model should be not null!");
        model.setPassword(null);
        model.setLastActiveDate(new Date());
        model.setPreference(new ClientPreference());
        Long pk = super.save(model);
        RoleCode[] codes = { RoleCode.CLIENT };
        List<Role> roles = this.roleService.queryRoleByCodes(codes);
        if (!CollectionUtils.isEmpty(roles)) {
            List<Long> roleIds = new ArrayList<Long>();
            for (Role role : roles) {
                roleIds.add(role.getId());
            }
            this.profileRoleService.refreshProfileRoles(pk, roleIds);
        }
        interestListService.createForClient(pk);
        return pk;
    }

    @Override
    public void update(Client model, String[] ignoreProps) {
        model.setPassword(null);
        super.update(model, ignoreProps);
    }

}
