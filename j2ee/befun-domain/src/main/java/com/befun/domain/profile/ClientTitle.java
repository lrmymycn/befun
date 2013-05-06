package com.befun.domain.profile;

public enum ClientTitle {

    MR, MRS, MS, DR;

    public static ClientTitle getValue(int ordinal) {
        for (ClientTitle e : ClientTitle.values()) {
            if (e.ordinal() == ordinal) {
                return e;
            }
        }
        throw new IllegalArgumentException(ordinal + " not acceptable!");
    }
}
