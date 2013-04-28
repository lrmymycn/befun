package com.befun.web.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class BooleanConverter extends StrutsTypeConverter {

    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        Boolean rs = null;
        String dateString = null;
        if (values != null && values.length > 0) {
            dateString = values[0];
            if (dateString != null) {
                if (dateString.equalsIgnoreCase("null")) {
                    rs = null;
                } else {
                    try {
                        rs = Boolean.parseBoolean(dateString);
                    } catch (Exception ex) {
                        rs = false;
                    }
                }
            } else {
                rs = false;
            }
        }
        return rs;
    }

    @Override
    public String convertToString(Map context, Object o) {
        Boolean bl = (Boolean) o;
        if (bl != null) {
            return bl.toString();
        }
        return null;
    }

}
