package com.befun.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class Modification implements Serializable {

    private static final long serialVersionUID = -1201485770176661386L;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

    public static Modification createDefault() {
        Modification modification = new Modification();
        modification.setCreationDate(new Date());
        modification.setLastModifiedDate(new Date());
        return modification;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Modification other = (Modification) obj;
        if (creationDate == null) {
            if (other.creationDate != null) return false;
        } else if (!creationDate.equals(other.creationDate)) return false;
        if (lastModifiedDate == null) {
            if (other.lastModifiedDate != null) return false;
        } else if (!lastModifiedDate.equals(other.lastModifiedDate)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProfileModification [creationDate=" + creationDate + ", lastModifiedDate=" + lastModifiedDate + "]";
    }

}
