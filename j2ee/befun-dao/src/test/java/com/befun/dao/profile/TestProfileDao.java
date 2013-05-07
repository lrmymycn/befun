package com.befun.dao.profile;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.profile.ProfileDao;
import com.befun.domain.profile.Gender;
import com.befun.domain.profile.Profile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-datasource.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestProfileDao {

    @Resource
    @Qualifier("ProfileDao")
    private ProfileDao target;

    @Test
    public void testSave() {
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

    @Test
    public void testQuery() {
        List<Profile> rs = target.queryAll();
        for (Profile e : rs) {
            System.out.println(e);
        }
    }
}
