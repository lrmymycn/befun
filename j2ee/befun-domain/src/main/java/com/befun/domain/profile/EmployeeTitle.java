package com.befun.domain.profile;

public enum EmployeeTitle {

    MANAGER, SALE, JUNIOR_SALE;

    public static EmployeeTitle getValue(int ordinal) {
        for (EmployeeTitle e : EmployeeTitle.values()) {
            if (e.ordinal() == ordinal) {
                return e;
            }
        }
        throw new IllegalArgumentException(ordinal + " not acceptable!");
    }
}
