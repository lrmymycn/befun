package com.befun.domain.profile;

public enum ProfileType {

    GENERAL, EMPLOYEE, SALE, MANAGER, CLIENT, REFERRAL;

    public static ProfileType getValue(int ordinal) {
        for (ProfileType e : ProfileType.values()) {
            if (e.ordinal() == ordinal) {
                return e;
            }
        }
        throw new IllegalArgumentException(ordinal + " not acceptable!");
    }
}
