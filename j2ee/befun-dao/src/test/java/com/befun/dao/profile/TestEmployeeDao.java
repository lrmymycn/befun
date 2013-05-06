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

import com.befun.dao.profile.EmployeeDao;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-datasource.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestEmployeeDao {

    @Resource
    @Qualifier("EmployeeDao")
    private EmployeeDao target;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        String username = "employee";
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
        String employeeNumber = "employeeNumber";
        String abn = "abn";
        String gst = "gst";
        String title = "title";
        String titleDesc = "titleDesc";
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setGender(Gender.MALE);
        employee.setGivenName(givenName);
        employee.setSurname(surname);
        employee.setHomeAddress(homeAddress);
        employee.setHomePhone(homePhone);
        employee.setHomePostcode(homePostcode);
        employee.setMailAddress(mailAddress);
        employee.setMailPostcode(mailPostcode);
        employee.setMobileNumber(mobileNumber);
        employee.setMobileNumber1(mobileNumber1);
        employee.setPreferredName(preferredName);
        employee.setEmployeeNumber(employeeNumber);
        employee.setAbn(abn);
        employee.setGst(gst);
        employee.setTitle(title);
        employee.setTitleDesc(titleDesc);
        employee.setRank(2);
        target.save(employee);
    }

    @Test
    public void testQuery() {
        List<Employee> rs = target.queryAll();
        for (Employee e : rs) {
            System.out.println(e);
        }
    }
}
