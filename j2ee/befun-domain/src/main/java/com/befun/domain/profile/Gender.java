package com.befun.domain.profile;

public enum Gender {

    MALE, FEMALE, OTHER;

    public static Gender getValue(int ordinal) {
        for (Gender e : Gender.values()) {
            if (e.ordinal() == ordinal) {
                return e;
            }
        }
        throw new IllegalArgumentException(ordinal + " not acceptable!");
    }
}
