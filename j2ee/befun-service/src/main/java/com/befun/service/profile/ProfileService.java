package com.befun.service.profile;

import com.befun.domain.profile.Profile;
import com.befun.service.IBaseService;

public interface ProfileService extends IBaseService<Profile, Long> {

    Profile getByUserName(String userName);

    void enable(Long id);

    void disable(Long id);

    void expire(Long id);

    void renewal(Long id);

    void lock(Long id);

    void unlock(Long id);
    
    boolean exists(String userName);
}
