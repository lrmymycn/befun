package com.befun.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.profile.ProfileDao;
import com.befun.domain.profile.Profile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-datasource.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestProfileDao {

    @Resource
    private ProfileDao target;

    @Test
    public void testSave() {
        Profile profile = new Profile();
        String employeeNumber = "employeeNumber";
        String username = "username";
        String password = "password";
        String firstName = "firstName";
        String lastName = "lastName";
        String middleName = "middleName";
        profile.setEmployeeNumber(employeeNumber);
        profile.setUsername(username);
        profile.setPassword(password);
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setMiddleName(middleName);
        target.save(profile);
    }
}
