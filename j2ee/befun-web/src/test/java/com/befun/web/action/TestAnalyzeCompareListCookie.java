package com.befun.web.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Test;


public class TestAnalyzeCompareListCookie {

    String testValue = "%5B%7B%22id%22%3A1%2C%22image%22%3A%22%2Fimg%2Ffp%2Fmedium%2FC%20S%20504%2C%20603%2C%20703%2C%20803%2C%20903%2C%201003%2C%201103%2C%201203%2C%201303%2C%201403%2C%201503%2C%201603%2C%201703%2C%201803%2C%201903%2C%202003%2C%202103%2C%202203.jpg%22%7D%2C%7B%22id%22%3A7%2C%22image%22%3A%22%2Fimg%2Ffp%2Fmedium%2F6%20S%20101%2C201%2C301%2C401.jpg%22%7D%2C%7B%22id%22%3A12%2C%22image%22%3A%22%2Fimg%2Ffp%2Fmedium%2F6%20S%20102%2C202%2C302%2C402%2CM%2C113%2C213%2C313%2C413.jpg%22%7D%5D";
    
    @Test
    public void testAnalyze(){
        try {
            String value = URLDecoder.decode(testValue,"UTF-8");
            Object o = JSONUtil.deserialize(value);
            List<Object> os = (List<Object>)(o);
            for(Object jo: os){
                HashMap<?,?> ho = (HashMap<?,?>)jo;
                System.out.println("id:"+ho.get("id"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
