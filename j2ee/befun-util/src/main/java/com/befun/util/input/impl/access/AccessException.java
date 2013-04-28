package com.befun.util.input.impl.access;

public class AccessException extends RuntimeException {

    private static final long serialVersionUID = -5924994617741804101L;

    public AccessException() {
        super();
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessException(String message) {
        super(message);
    }

    public AccessException(Throwable cause) {
        super(cause);
    }

}
