package com.befun.service.profile;

import java.util.List;

import com.befun.domain.profile.ProfileRole;
import com.befun.service.IBaseService;

public interface ProfileRoleService extends IBaseService<ProfileRole, Long> {

    List<ProfileRole> queryRolesByProfileId(Long profileId);

}
