package com.befun.domain.estate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class ModelModification implements Serializable {

    private static final long serialVersionUID = -1201485770176661386L;

    @Column(name = "REMOVED")
    private boolean removed;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    @Column(name = "ENABLED")
    private boolean enabled;
    
    public static ModelModification createDefault(){
        ModelModification modelModification = new ModelModification();
        modelModification.setCreationDate(new Date());
        modelModification.setLastModifiedDate(new Date());
        modelModification.setEnabled(true);
        modelModification.setRemoved(false);
        return modelModification;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
        result = prime * result + (removed ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ModelModification other = (ModelModification) obj;
        if (creationDate == null) {
            if (other.creationDate != null) return false;
        } else if (!creationDate.equals(other.creationDate)) return false;
        if (enabled != other.enabled) return false;
        if (lastModifiedDate == null) {
            if (other.lastModifiedDate != null) return false;
        } else if (!lastModifiedDate.equals(other.lastModifiedDate)) return false;
        if (removed != other.removed) return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseModel [removed=" + removed + ", creationDate=" + creationDate + ", lastModifiedDate=" + lastModifiedDate + ", enabled=" + enabled + "]";
    }
}
