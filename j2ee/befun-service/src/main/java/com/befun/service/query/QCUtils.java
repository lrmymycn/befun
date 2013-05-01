package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

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

    public static Criterion parseCounts(String propertyName, String countStr) {
        if (StringUtils.isBlank(countStr)) {
            return null;
        }
        String[] countStrArray = countStr.split(",");
        int l = countStrArray.length;
        if (l == 0) {
            return null;
        }
        List<Criterion> rs = new ArrayList<Criterion>();
        Criterion tmp = null;
        for (String str : countStrArray) {
            try {
                Short count = Short.parseShort(str);
                if (count == null) {
                    continue;
                }
                tmp = Restrictions.eq(propertyName, count);
                rs.add(tmp);
            } catch (NumberFormatException ex) {
                if (!str.endsWith("+")) {
                    continue;
                }
                int i = str.indexOf("+");
                str = str.substring(0, i);
                try {
                    Short count = Short.parseShort(str);
                    if (count == null) {
                        continue;
                    }
                    tmp = Restrictions.gt(propertyName, count);
                    rs.add(tmp);
                } catch (NumberFormatException ne) {
                    continue;
                }
            }
        }
        if (rs.size() <= 0) {
            return null;
        }
        return Restrictions.or(rs.toArray(new Criterion[] {}));
    }

    public static Integer getRealPrice(Integer priceEnum) {
        if (priceEnum == null) {
            return null;
        }
        Integer realPrice = 0;
        switch (priceEnum) {
        case 0:
            realPrice = null;
            break;
        case 1:
            realPrice = 450000;
            break;
        case 2:
            realPrice = 550000;
            break;
        case 3:
            realPrice = 650000;
            break;
        case 4:
            realPrice = 750000;
            break;
        case 5:
            realPrice = 850000;
            break;
        case 6:
            realPrice = null;
            break;
        default:
            realPrice = null;
            break;
        }
        return realPrice;
    }
}
