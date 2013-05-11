package com.befun.web.box;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SessionContainer implements Serializable {

    private static final long serialVersionUID = 4649442793385150136L;

    private Map<String, Serializable> contents = new HashMap<String, Serializable>();

    synchronized public void setProperty(String propertyName, Serializable property) {
        this.contents.put(propertyName, property);
    }

    synchronized public Serializable getProperty(String propertyName) {
        return this.contents.get(propertyName);
    }
}
