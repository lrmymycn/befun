package com.befun.web;

import org.junit.Test;


public class TestNumberFormat {

    
    @Test
    public void testDouble(){
        Double d = 1.23901128233333333;
        String s = ""+d;
        System.out.println(s);
    }
    
    @Test
    public void testStringToDouble(){
        String str = " 1.123, 2.123 ; 3.1111,  4.11111 ;";
        String[] coordinates = str.split(";");
        for(String c:coordinates){
            String[] ll = c.split(",");
            if(ll.length!=2){
                throw new IllegalArgumentException("Invalid argument!");
            }
            String latitude = ll[0];
            String longitude = ll[1];
            System.out.println(toDouble(latitude));
            System.out.println(toDouble(longitude));
        }
    }
    @Test
    public void testStringToDouble1(){
        String str = " 1.123, 2.123 ; 3.1111,  4.11111 ";
        String[] coordinates = str.split(";");
        for(String c:coordinates){
            String[] ll = c.split(",");
            if(ll.length!=2){
                throw new IllegalArgumentException("Invalid argument!");
            }
            String latitude = ll[0];
            String longitude = ll[1];
            System.out.println(toDouble(latitude));
            System.out.println(toDouble(longitude));
        }
    }

    @Test
    public void testStringToDouble_exception(){
        String str = " 1.123, 2.123 ; 3.1111,4,  4.11111 ;";
        String[] coordinates = str.split(";");
        for(String c:coordinates){
            String[] ll = c.split(",");
            if(ll.length!=2){
                throw new IllegalArgumentException("Invalid argument!");
            }
            String latitude = ll[0];
            String longitude = ll[1];
            System.out.println(toDouble(latitude));
            System.out.println(toDouble(longitude));
        }
    }

    @Test
    public void testStringToDouble_exception1(){
        String str = " 1.123 ; 3.1111,4,  4.11111 ;";
        String[] coordinates = str.split(";");
        for(String c:coordinates){
            String[] ll = c.split(",");
            if(ll.length!=2){
                throw new IllegalArgumentException("Invalid argument!");
            }
            String latitude = ll[0];
            String longitude = ll[1];
            System.out.println(toDouble(latitude));
            System.out.println(toDouble(longitude));
        }
    }
    
    private Double toDouble(String s){
        String ds = s.trim();
        return Double.parseDouble(ds);
    }
}
