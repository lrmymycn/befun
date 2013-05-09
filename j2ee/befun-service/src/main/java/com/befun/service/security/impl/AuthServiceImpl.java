package com.befun.service.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.domain.profile.Profile;
import com.befun.domain.profile.ProfileRole;
import com.befun.service.profile.ProfileService;
import com.befun.service.security.AuthService;
import com.befun.service.security.MyUser;

@Service("AuthService")
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

    private static final String[] IGNORE_PROPERTIES = new String[] { "id", "password", "profileRoles" };

    @Resource
    @Qualifier(value = "ProfileService")
    private ProfileService profileService;

    @Resource
    @Qualifier(value = "BefunPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileService.getByUserName(username);
        if (profile == null) {
            throw new UsernameNotFoundException("User " + username + " not found!");
        }
        boolean accountEnabled = profile.isEnabled();
        boolean accountNonExpired = !profile.isExpired();
        boolean credentialsNonExpired = !profile.isCredentialsExpired();
        boolean accountNonLocked = !profile.isLocked();
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<ProfileRole> profileRoles = profile.getProfileRoles();
        if (profileRoles != null) {
            for (ProfileRole pr : profileRoles) {
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(pr.getRole().getCode().name());
                authorities.add(auth);
            }
        }
        MyUser user = new MyUser(profile.getUsername(), profile.getPassword(), accountEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return user;
    }

    @Override
    public void createUser(Profile profile) {
        String encodedPassword = this.passwordEncoder.encode(profile.getPassword());
        profile.setPassword(encodedPassword);
        profileService.save(profile);
    }

    @Override
    public void updateUser(Profile profile) {
        Long id = profile.getId();
        Profile exist = profileService.get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Profile with id:" + id + " not found!");
        }
        BeanUtils.copyProperties(profile, exist, IGNORE_PROPERTIES);
        profileService.update(exist);
    }

    @Override
    public void changePassword(Long profileId, String newPassword) {
        Profile exist = profileService.get(profileId);
        if (exist == null) {
            throw new IllegalArgumentException("Profile with id:" + profileId + " not found!");
        }
        String encodedPassword = this.passwordEncoder.encode(newPassword);
        exist.setPassword(encodedPassword);
        profileService.update(exist);
    }
}
