package com.befun.domain;

import java.io.Serializable;
import java.util.List;

public class PaginationBean<M> implements Serializable {

    private static final long serialVersionUID = -7631749948785002366L;

    private long pageNumber;

    private int pageSize = 20;

    private long totalCount;

    private long totalPageCount = -1;

    private List<M> models;

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long pTotalCount) {
        totalCount = pTotalCount;
    }

    public synchronized long getTotalPageCount() {
        if (totalPageCount < 0) {
            totalPageCount = totalCount / pageSize;
            if (totalCount % pageSize > 0) {
                totalPageCount += 1;
            }
        }
        return totalPageCount;
    }

    public List<M> getModels() {
        return models;
    }

    public void setModels(List<M> pModels) {
        models = pModels;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((models == null) ? 0 : models.hashCode());
        result = prime * result + (int) (pageNumber ^ (pageNumber >>> 32));
        result = prime * result + pageSize;
        result = prime * result + (int) (totalCount ^ (totalCount >>> 32));
        result = prime * result + (int) (totalPageCount ^ (totalPageCount >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PaginationBean<?> other = (PaginationBean<?>) obj;
        if (models == null) {
            if (other.models != null) return false;
        } else if (!models.equals(other.models)) return false;
        if (pageNumber != other.pageNumber) return false;
        if (pageSize != other.pageSize) return false;
        if (totalCount != other.totalCount) return false;
        if (totalPageCount != other.totalPageCount) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PaginationBean [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPageCount=" + totalPageCount
               + ", models=" + models + "]";
    }

}
