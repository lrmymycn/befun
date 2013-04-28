package com.befun.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.befun.domain.profile.Profile;

public interface AuthService extends UserDetailsService {

    void createUser(Profile profile);

    void updateUser(Profile profile);

    void changePassword(Long profileId, String newPassword);
}
