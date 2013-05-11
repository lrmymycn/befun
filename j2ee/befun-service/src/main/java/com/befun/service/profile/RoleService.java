package com.befun.service.profile;

import java.util.List;

import com.befun.domain.profile.Role;
import com.befun.domain.profile.RoleCode;
import com.befun.service.IBaseService;

public interface RoleService extends IBaseService<Role, Long> {

    List<Role> queryRoleByCodes(RoleCode... codes);
}
