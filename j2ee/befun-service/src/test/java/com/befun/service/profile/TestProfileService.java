package com.befun.service.profile;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Gender;
import com.befun.domain.profile.Profile;
import com.befun.domain.profile.ProfileRole;
import com.befun.domain.profile.Role;
import com.befun.service.ICommonService;
import com.befun.service.SpringTestBase;

public class TestProfileService extends SpringTestBase {

    @Resource
    @Qualifier("ProfileService")
    private ProfileService target;

    @Resource
    @Qualifier("CommonService")
    private ICommonService commonService;

    @Test
    public void testListProfile() {
        IQueryCondition queryCondition = new QueryCondition();
        target.query(queryCondition);
    }

    @Test
    public void testSaveProfileWithRole() {
        Profile profile = new Profile();
        String username = "username";
        String password = "password";
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

        Role role = new Role();
        role.setId(1l);
        ProfileRole pr = new ProfileRole();
        pr.setProfile(profile);
        pr.setRole(role);
        Set<ProfileRole> prs = new HashSet<ProfileRole>();
        prs.add(pr);
        profile.setProfileRoles(prs);
        
        target.save(profile);
    }

    @Test
    public void testUpdateProfileWithRole() {
        Profile profile = new Profile();
        profile.setId(3l);
        String username = "username";
        String password = "password";
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
        profile.setProfileRoles(null);
        target.update(profile);
    }
    
    @Test
    public void testUpdateProfileRole(){
        Profile profile = new Profile();
        profile.setId(3l);
        
        Role role = new Role();
        role.setId(1l);
        ProfileRole pr = new ProfileRole();
        pr.setProfile(profile);
        pr.setRole(role);
        commonService.save(pr);
    }

    @Test
    public void testSaveProfile() {
        Profile profile = new Profile();
        String username = "username";
        String password = "password";
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
        target.save(profile);
    }

}
