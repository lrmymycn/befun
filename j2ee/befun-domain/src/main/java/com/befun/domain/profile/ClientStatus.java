package com.befun.domain.profile;

public enum ClientStatus {

    PR, CITIZEN, OVERSEAS_INVESTOR, STUDENT;

    public static ClientStatus getValue(int ordinal) {
        for (ClientStatus e : ClientStatus.values()) {
            if (e.ordinal() == ordinal) {
                return e;
            }
        }
        throw new IllegalArgumentException(ordinal + " not acceptable!");
    }
}
