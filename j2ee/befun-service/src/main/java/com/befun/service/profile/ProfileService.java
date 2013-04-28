package com.befun.service.profile;

import com.befun.domain.profile.Profile;
import com.befun.service.IBaseService;

public interface ProfileService extends IBaseService<Profile, Long> {

    Profile getByUserName(String userName);
}
