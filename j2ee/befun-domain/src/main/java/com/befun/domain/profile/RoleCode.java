package com.befun.domain.profile;

public enum RoleCode {

    SUPER, DATA_ADMIN, MANAGER, SALE, CLIENT, REFERRAL, PUBLIC, INTERNAL_EMPLOYEE, ACCOUNTING, SENIOR_SALE;

    public static RoleCode getValue(int ordinal) {
        for (RoleCode e : RoleCode.values()) {
            if (e.ordinal() == ordinal) {
                return e;
            }
        }
        throw new IllegalArgumentException(ordinal + " not acceptable!");
    }
}
