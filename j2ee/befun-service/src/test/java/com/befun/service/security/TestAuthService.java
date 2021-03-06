package com.befun.service.security;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.profile.Gender;
import com.befun.domain.profile.Profile;
import com.befun.service.SpringTestBase;

public class TestAuthService extends SpringTestBase {

    @Resource
    @Qualifier("AuthService")
    private AuthService target;

    @Test
    public void testCreateUser() {
        Profile profile = new Profile();
        String username = "auth1";
        String password = "@dm!n123";
        String givenName = "givenName";
        String surname = "surname";
        String homeAddress = "homeAddress";
        String homePhone = "homePhone";
        String homePostcode = "homePostcode";
        String mailAddress = "mailAddress";
        String mailPostcode = "mailPostcode";
        String mobileNumber = "mobileNumber";
        String mobileNumber1 = "mobileNumber1";
        String preferredName = "preferredName";
        profile.setUsername(username);
        profile.setPassword(password);
        profile.setGender(Gender.MALE);
        profile.setGivenName(givenName);
        profile.setSurname(surname);
        profile.setHomeAddress(homeAddress);
        profile.setHomePhone(homePhone);
        profile.setHomePostcode(homePostcode);
        profile.setMailAddress(mailAddress);
        profile.setMailPostcode(mailPostcode);
        profile.setMobileNumber(mobileNumber);
        profile.setMobileNumber1(mobileNumber1);
        profile.setPreferredName(preferredName);        
        target.createUser(profile);
    }
    
    @Test
    public void testChangePassword() {
        target.changePassword(9l, "@dm!n123");
    }
}
