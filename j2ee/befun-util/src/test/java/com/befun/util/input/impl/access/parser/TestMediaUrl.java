package com.befun.util.input.impl.access.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestMediaUrl {

    private String originalUrl = "/img/fp/AC-P-G06,G2,G15.jpg";

    @Test
    public void testParse() {
        String head = getTypeHead(this.originalUrl);
        assertEquals("/img/fp/", head);
        String filename = getFileName(this.originalUrl);
        assertEquals("AC-P-G06,G2,G15.jpg", filename);
    }
    
    @Test
    public void testParse1() {
        String destUrl = this.getDestUrl(this.originalUrl, "large");
        assertEquals("/img/fp/large/AC-P-G06,G2,G15.jpg", destUrl);
        destUrl = this.getDestUrl(this.originalUrl, "small");
        assertEquals("/img/fp/small/AC-P-G06,G2,G15.jpg", destUrl);
        destUrl = this.getDestUrl(this.originalUrl, "medium");
        assertEquals("/img/fp/medium/AC-P-G06,G2,G15.jpg", destUrl);
    }

    private String getTypeHead(String oriUrl) {
        String regex = "^(/[^/]+/[^/]+/)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(oriUrl);
        if (m.find()) {
            String t = m.group(1);
            return t;
        }
        return null;
    }

    private String getFileName(String oriUrl) {
        String regex = "^(/[^/]+/[^/]+/)(.+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(oriUrl);
        if (m.find()) {
            String t = m.group(2);
            return t;
        }
        return null;
    }

    private String getDestUrl(String oriUrl, String size) {
        String regex = "^(/[^/]+/[^/]+/)(.+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(oriUrl);
        if (m.find()) {
            String head = m.group(1);
            String fileName = m.group(2);
            return head + size + "/" + fileName;
        }
        return oriUrl;
    }
}
