package com.befun.service.query;

import org.apache.commons.lang3.StringUtils;

public class QCUtils {

    public static void appendWhereClause(StringBuilder sb, String logic, String clause) {
        if (sb.length() > 0) {
            sb.append(logic).append(" ");
        }
        sb.append(clause);
    }

    public static String generatePropertyName(String alias, String propertyName) {
        if (StringUtils.isBlank(alias)) {
            return propertyName;
        }
        return alias + "." + propertyName;
    }
}
