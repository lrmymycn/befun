package com.befun.web.view.cachest;

import java.io.Serializable;

public class CacheStatisticsView<T> implements Serializable {

    private static final long serialVersionUID = -3729874282062800634L;

    private String name;

    private T st;

    public CacheStatisticsView(String name, T st) {
        super();
        this.name = name;
        this.st = st;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getSt() {
        return st;
    }

    public void setSt(T st) {
        this.st = st;
    }

}
