package com.befun.service.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.domain.estate.FloorplanType;
import com.befun.domain.estate.OrientationType;

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

    public static Criterion parseFloorplanTypesCriterion(String propertyName, String floorplanTypeStr) {
        List<FloorplanType> types = parseFloorplanTypes(floorplanTypeStr);
        if (types.isEmpty()) {
            return null;
        }
        List<Criterion> rs = new ArrayList<Criterion>();
        Criterion tmp = null;
        for (FloorplanType type : types) {
            tmp = Restrictions.eq(propertyName, type);
            rs.add(tmp);
        }
        return Restrictions.or(rs.toArray(new Criterion[] {}));
    }

    public static List<FloorplanType> parseFloorplanTypes(String floorplanTypeStr) {
        List<FloorplanType> rs = new ArrayList<FloorplanType>();
        if (StringUtils.isBlank(floorplanTypeStr)) {
            return rs;
        }
        String[] floorplanTypeStrArray = floorplanTypeStr.split(",");
        int l = floorplanTypeStrArray.length;
        if (l == 0) {
            return rs;
        }
        for (String str : floorplanTypeStrArray) {
            try {
                str = str.trim();
                FloorplanType type = FloorplanType.valueOf(str);
                if (type != null) {
                    rs.add(type);
                }

            } catch (Exception ex) {
                continue;
            }
        }
        return rs;
    }

    public static Criterion parseOrientationsCriterion(String orientationStr, String orientationEastProp, String orientationSouthProp,
                                                       String orientationWestProp, String orientationNorthProp) {
        List<OrientationType> types = parseOrientations(orientationStr);
        if (types.isEmpty()) {
            return null;
        }
        List<Criterion> rs = new ArrayList<Criterion>();
        Criterion tmp = null;
        for (OrientationType type : types) {
            switch (type) {
            case EAST:
                tmp = Restrictions.eq(orientationEastProp, true);
                rs.add(tmp);
                break;
            case SOUTH:
                tmp = Restrictions.eq(orientationSouthProp, true);
                rs.add(tmp);
                break;
            case WEST:
                tmp = Restrictions.eq(orientationWestProp, true);
                rs.add(tmp);
                break;
            case NORTH:
                tmp = Restrictions.eq(orientationNorthProp, true);
                rs.add(tmp);
                break;
            default:
                break;
            }
        }
        return Restrictions.or(rs.toArray(new Criterion[] {}));
    }

    public static List<OrientationType> parseOrientations(String orientationStr) {
        List<OrientationType> rs = new ArrayList<OrientationType>();
        if (StringUtils.isBlank(orientationStr)) {
            return rs;
        }
        String[] orientationStrArray = orientationStr.split(",");
        int l = orientationStrArray.length;
        if (l == 0) {
            return rs;
        }
        for (String str : orientationStrArray) {
            try {
                str = str.trim();
                OrientationType type = OrientationType.valueOf(str);
                if (type != null) {
                    rs.add(type);
                }
            } catch (Exception ex) {
                continue;
            }
        }
        return rs;
    }

    public static Criterion parseCountsCriterion(String propertyName, String countStr) {
        List<String> counts = parseCounts(countStr);
        if (counts.isEmpty()) {
            return null;
        }
        List<Criterion> rs = new ArrayList<Criterion>();
        Criterion tmp = null;
        for (String str : counts) {
            try {
                if (str.endsWith("+")) {
                    int i = str.indexOf("+");
                    str = str.substring(0, i);
                    Short count = Short.parseShort(str);
                    if (count != null) {
                        tmp = Restrictions.gt(propertyName, count);
                        rs.add(tmp);
                    }
                } else {
                    Short count = Short.parseShort(str);
                    if (count != null) {
                        tmp = Restrictions.eq(propertyName, count);
                        rs.add(tmp);
                    }
                }
            } catch (NumberFormatException ex) {
                continue;
            }
        }
        if (rs.size() <= 0) {
            return null;
        }
        return Restrictions.or(rs.toArray(new Criterion[] {}));
    }

    public static List<String> parseCounts(String countStr) {
        List<String> rs = new ArrayList<String>();
        if (StringUtils.isBlank(countStr)) {
            return rs;
        }
        String[] countStrArray = countStr.split(",");
        int l = countStrArray.length;
        if (l == 0) {
            return rs;
        }
        for (String str : countStrArray) {
            str = str.trim();
            if (!StringUtils.isEmpty(str)) {
                rs.add(str);
            }
        }
        return rs;
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
