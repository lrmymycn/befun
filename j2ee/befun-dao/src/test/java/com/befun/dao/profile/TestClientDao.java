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

import com.befun.dao.profile.ClientDao;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientPreference;
import com.befun.domain.profile.ClientStatus;
import com.befun.domain.profile.ClientTitle;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-datasource.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestClientDao {

    @Resource
    @Qualifier("ClientDao")
    private ClientDao target;

    @Test
    public void testSave() {
        Client client = new Client();
        String username = "client";
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
        client.setUsername(username);
        client.setPassword(password);
        client.setGender(Gender.MALE);
        client.setGivenName(givenName);
        client.setSurname(surname);
        client.setHomeAddress(homeAddress);
        client.setHomePhone(homePhone);
        client.setHomePostcode(homePostcode);
        client.setMailAddress(mailAddress);
        client.setMailPostcode(mailPostcode);
        client.setMobileNumber(mobileNumber);
        client.setMobileNumber1(mobileNumber1);
        client.setPreferredName(preferredName);
        client.setPurchaseType1(false);
        client.setPurchaseType2(true);
        client.setPurchaseType3(false);
        client.setPurchaseType4(true);
        client.setPurchaseTypeFirst(false);
        client.setPurchaseTypeInverstor(true);
        client.setPurchaseTypeOther(true);
        client.setPurchaseTypeOwner(false);
        client.setPurchaseTypeStudent(true);
        client.setTitle(ClientTitle.MR);
        client.setStatus(ClientStatus.CITIZEN);
        Employee currentEmployee = new Employee();
        currentEmployee.setId(4l);
        client.setCurrentEmployee(currentEmployee);
        ClientPreference preference = new ClientPreference();
        preference.setArea("area");
        preference.setTrains("trains");
        client.setPreference(preference);
        target.save(client);
    }

    @Test
    public void testQuery() {
        List<Client> rs = target.queryAll();
        for (Client e : rs) {
            System.out.println(e);
        }
    }
}
