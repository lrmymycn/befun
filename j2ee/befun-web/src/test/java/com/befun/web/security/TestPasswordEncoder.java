package com.befun.web.security;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class TestPasswordEncoder {

    private String rawPassword = "123asdf";

    private String secret = "befun.estate";

    private StandardPasswordEncoder standardPasswordEncoder1 = new StandardPasswordEncoder(secret);

    private StandardPasswordEncoder standardPasswordEncoder2 = new StandardPasswordEncoder(secret);

    @Test
    public void testStandard() {
        String encodedPassword = standardPasswordEncoder1.encode(this.rawPassword);
        assertTrue(standardPasswordEncoder1.matches(this.rawPassword, encodedPassword));
        assertTrue(standardPasswordEncoder2.matches(this.rawPassword, encodedPassword));
        encodedPassword = this.standardPasswordEncoder1.encode(this.rawPassword);
        assertTrue(standardPasswordEncoder1.matches(this.rawPassword, encodedPassword));
        assertTrue(standardPasswordEncoder2.matches(this.rawPassword, encodedPassword));
        encodedPassword = this.standardPasswordEncoder1.encode(this.rawPassword);
        assertTrue(standardPasswordEncoder1.matches(this.rawPassword, encodedPassword));
        assertTrue(standardPasswordEncoder2.matches(this.rawPassword, encodedPassword));
    }

    @Test
    public void testPassword() {
        String rawPass = "testDataAdmin";
        String encodedPassword = standardPasswordEncoder1.encode(rawPass);
        System.out.println("raw:" + rawPass + "|encoded:" + encodedPassword);
        rawPass = "testSale";
        encodedPassword = standardPasswordEncoder1.encode(rawPass);
        System.out.println("raw:" + rawPass + "|encoded:" + encodedPassword);
        rawPass = "testCustomer";
        encodedPassword = standardPasswordEncoder1.encode(rawPass);
        System.out.println("raw:" + rawPass + "|encoded:" + encodedPassword);
        rawPass = "testPublic";
        encodedPassword = standardPasswordEncoder1.encode(rawPass);
        System.out.println("raw:" + rawPass + "|encoded:" + encodedPassword);
        rawPass = "@dm!n123";
        encodedPassword = standardPasswordEncoder1.encode(rawPass);
        System.out.println("raw:" + rawPass + "|encoded:" + encodedPassword);
    }
}
