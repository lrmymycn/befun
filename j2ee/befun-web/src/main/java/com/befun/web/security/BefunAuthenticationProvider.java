package com.befun.web.security;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.befun.domain.profile.RoleCode;

@Component("BefunAuthenticationProvider")
public class BefunAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private static RoleCode[] LOGINABLE_ROLES = { RoleCode.ACCOUNTING, RoleCode.DATA_ADMIN, RoleCode.INTERNAL_EMPLOYEE, RoleCode.MANAGER, RoleCode.SALE,
                                                 RoleCode.SUPER };

    @Resource
    @Qualifier(value = "BefunPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Resource
    @Qualifier(value = "AuthService")
    private UserDetailsService userDetailsService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
            logger.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
        checkLoginableRole(userDetails);
    }

    private void checkLoginableRole(UserDetails userDetails) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();
        if (authorities == null || authorities.isEmpty()) {
            logger.debug("Authentication failed: roles empty");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
        for (GrantedAuthority a : authorities) {
            for (RoleCode c : LOGINABLE_ROLES) {
                if (c.name().equals(a.getAuthority())) {
                    return;
                }
            }
        }
        logger.debug("Authentication failed: no role can login");
        throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails loadedUser;

        try {
            loadedUser = this.getUserDetailsService().loadUserByUsername(username);
        } catch (Exception repositoryProblem) {
            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    protected void doAfterPropertiesSet() throws Exception {
        Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

}
