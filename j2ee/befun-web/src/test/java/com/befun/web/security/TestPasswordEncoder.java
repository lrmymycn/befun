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
    public void testMatchPassword() {
        String rawPassword = "@dm!n123";
        String encodedPassword = "742b1a515e013826c17b9ba8e08a846ba60648976863dbd7a487e7905b417060b5de8c0e9a8a0521";
        assertTrue(standardPasswordEncoder1.matches(rawPassword, encodedPassword));
        rawPassword = "test123";
        encodedPassword = "1509dcf1b2d67df38f142b6b8fb171080b7491bde4d9691590586bb993c7649adfead826ad3121b3";
        assertTrue(standardPasswordEncoder1.matches(rawPassword, encodedPassword));
    }

    @Test
    public void testPassword() {
        String rawPass = "test123";
        String encodedPassword = standardPasswordEncoder1.encode(rawPass);
        System.out.println("raw:" + rawPass + "|encoded:" + encodedPassword);
    }
}
