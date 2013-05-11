package com.befun.web.view.profile;

import java.io.Serializable;

import com.befun.web.view.BaseView;

public class BaseProfileView<M extends Serializable> extends BaseView<M> {

    private static final long serialVersionUID = 475553185427852488L;

    //
    protected Long id;

    public BaseProfileView() {
        super();
    }

    public BaseProfileView(M model) {
        super();
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BaseProfileView<?> other = (BaseProfileView<?>) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseProfileView [id=" + id + "]";
    }

}
