package com.befun.web.view;

import java.io.Serializable;
import java.util.Date;

public class BaseView<M extends Serializable> implements Serializable {

    private static final long serialVersionUID = 475553185427852488L;

    protected M model;

    //
    protected Long id;

    protected String bid;

    protected boolean removed;

    protected Date creationDate;

    protected Date lastModifiedDate;

    protected boolean enabled;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
        result = prime * result + (removed ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BaseView<?> other = (BaseView<?>) obj;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (creationDate == null) {
            if (other.creationDate != null) return false;
        } else if (!creationDate.equals(other.creationDate)) return false;
        if (enabled != other.enabled) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (lastModifiedDate == null) {
            if (other.lastModifiedDate != null) return false;
        } else if (!lastModifiedDate.equals(other.lastModifiedDate)) return false;
        if (removed != other.removed) return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseView [id=" + id + ", bid=" + bid + ", removed=" + removed + ", creationDate=" + creationDate + ", lastModifiedDate="
               + lastModifiedDate + ", enabled=" + enabled + "]";
    }

}
