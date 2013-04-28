package com.befun.util.input.impl.access;

import java.util.Date;
import java.util.Map;

public class AccessUtil {

    public static Boolean parseToBoolean(Byte value) {
        if (value == null) {
            return null;
        }
        return value != 0;
    }

    public static boolean parseToBool(Byte value) {
        if (value == null) {
            return false;
        }
        return value != 0;
    }

    public static Boolean getBoolean(Map<String, Object> col, String columnLabel) {
        return AccessUtil.parseToBoolean(getByte(col, columnLabel));
    }

    public static boolean getBool(Map<String, Object> col, String columnLabel) {
        return AccessUtil.parseToBool(getByte(col, columnLabel));
    }

    public static Object getObject(Map<String, Object> col, String columnLabel) {
        Object rs = col.get(columnLabel);
        System.out.println("Property:" + columnLabel + " , Type:" + rs.getClass());
        System.out.println("Property:" + columnLabel + " , Value:" + rs);
        return rs;
    }

    public static String getString(Map<String, Object> col, String columnLabel) {
        return (String) col.get(columnLabel);
    }

    public static Byte getByte(Map<String, Object> col, String columnLabel) {
        return (Byte) col.get(columnLabel);
    }

    public static Short getShort(Map<String, Object> col, String columnLabel) {
        return (Short) col.get(columnLabel);
    }

    public static Integer getInteger(Map<String, Object> col, String columnLabel) {
        return (Integer) col.get(columnLabel);
    }

    public static Long getLong(Map<String, Object> col, String columnLabel) {
        return (Long) col.get(columnLabel);
    }

    public static Double getDouble(Map<String, Object> col, String columnLabel) {
        return (Double) col.get(columnLabel);
    }

    public static Date getDate(Map<String, Object> col, String columnLabel) {
        return (Date) col.get(columnLabel);
    }
}
