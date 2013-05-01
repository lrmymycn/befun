package com.befun.util.input.impl.access.parser;

public class ParseUtils {

    public static Boolean getEast(Short orientation) {
        if (orientation == null) {
            return null;
        }
        int rs = orientation % 2;
        return rs != 0;
    }

    public static Boolean getSouth(Short orientation) {
        if (orientation == null) {
            return null;
        }
        int ori = orientation >> 1;
        int rs = ori % 2;
        return rs != 0;
    }

    public static Boolean getWest(Short orientation) {
        if (orientation == null) {
            return null;
        }
        int ori = orientation >> 2;
        int rs = ori % 2;
        return rs != 0;
    }

    public static Boolean getNorth(Short orientation) {
        if (orientation == null) {
            return null;
        }
        int ori = orientation >> 3;
        int rs = ori % 2;
        return rs != 0;
    }
}
