package com.befun.dao.common;

import java.io.Serializable;

import org.hibernate.FetchMode;

public class FetchConfig implements Serializable {

    private static final long serialVersionUID = -7568399843474591047L;

    private String propertyName;

    private FetchMode fetchMode;

    public FetchConfig() {
        super();
    }

    public FetchConfig(String propertyName, FetchMode fetchMode) {
        super();
        this.propertyName = propertyName;
        this.fetchMode = fetchMode;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public FetchMode getFetchMode() {
        return fetchMode;
    }

    public void setFetchMode(FetchMode fetchMode) {
        this.fetchMode = fetchMode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fetchMode == null) ? 0 : fetchMode.hashCode());
        result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        FetchConfig other = (FetchConfig) obj;
        if (fetchMode != other.fetchMode) return false;
        if (propertyName == null) {
            if (other.propertyName != null) return false;
        } else if (!propertyName.equals(other.propertyName)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "FetchConfig [propertyName=" + propertyName + ", fetchMode=" + fetchMode + "]";
    }

}
