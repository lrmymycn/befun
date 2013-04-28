package com.befun.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.jmesa.limit.Action;

public class JmesaUtils {

    public static String getJmesaParam(HttpServletRequest request, Action action, String tableName) {
        String paraName = tableName + "_" + action.toParam();
        String rs = request.getParameter(paraName);
        return rs;
    }
}
