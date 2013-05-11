package com.befun.web.view;

import java.io.Serializable;

public class BaseView<M extends Serializable> implements Serializable {

    private static final long serialVersionUID = 475553185427852488L;

    protected M model;

    public BaseView() {
        super();
    }

    public BaseView(M model) {
        super();
        this.model = model;
    }

    public M getModel() {
        return model;
    }
}
