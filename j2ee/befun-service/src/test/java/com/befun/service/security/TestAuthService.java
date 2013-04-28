package com.befun.service.security;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.profile.Profile;
import com.befun.service.SpringTestBase;

public class TestAuthService extends SpringTestBase {

    @Resource
    @Qualifier("AuthService")
    private AuthService target;

    @Test
    public void testCreateUser() {
        Profile profile = new Profile();
        profile.setId(3l);
        String employeeNumber = "employeeNumber";
        String username = "admin";
        String password = "@dm!n123";
        String firstName = "firstName";
        String lastName = "lastName";
        String middleName = "middleName";
        profile.setEmployeeNumber(employeeNumber);
        profile.setUsername(username);
        profile.setPassword(password);
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setMiddleName(middleName);
        
        target.createUser(profile);
    }
    
    @Test
    public void testChangePassword() {
        target.changePassword(9l, "@dm!n123");
    }
}
