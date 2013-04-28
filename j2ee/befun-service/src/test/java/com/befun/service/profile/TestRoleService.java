package com.befun.service.profile;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.dao.common.IQueryCondition;
import com.befun.domain.profile.Role;
import com.befun.service.ICommonService;
import com.befun.service.SpringTestBase;

public class TestRoleService extends SpringTestBase {

    @Resource
    @Qualifier("CommonService")
    private ICommonService commonService;

    @Test
    public void testList() {
        IQueryCondition queryCondition = null;
        List<Role> roles = commonService.query(Role.class, queryCondition);
        System.out.println(roles.size());
    }

    @Test
    public void testSave() {
        Role role = new Role();
        String name = "USER";
        role.setName(name);
        String description = "ROLE Description";
        role.setDescription(description);
        commonService.save(role);

        Long roleId = role.getId();
        Role persistedRole = commonService.get(Role.class, roleId);
        assertNotNull(persistedRole);
    }

}
