package com.befun.domain.profile;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "EMPLOYEE")
@DiscriminatorValue("Employee")
@PrimaryKeyJoinColumn(name = "ID")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "employee")
public class Employee extends Profile {

    private static final long serialVersionUID = -4386534442370261990L;

    @Column(name = "TITLE", length = 255)
    private String title;

    @Column(name = "TITLE_DESC")
    private String titleDesc;

    @Column(name = "RANK")
    private Integer rank = 1;

    @Column(name = "EMPLOYEE_NUMBER", length = 255)
    private String employeeNumber;

    @Column(name = "ABN", length = 50)
    private String abn;

    @Column(name = "GST", length = 50)
    private String gst;

    public Employee(){
        super();
        this.setType(ProfileType.EMPLOYEE);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((abn == null) ? 0 : abn.hashCode());
        result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
        result = prime * result + ((gst == null) ? 0 : gst.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((titleDesc == null) ? 0 : titleDesc.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        if (abn == null) {
            if (other.abn != null) return false;
        } else if (!abn.equals(other.abn)) return false;
        if (employeeNumber == null) {
            if (other.employeeNumber != null) return false;
        } else if (!employeeNumber.equals(other.employeeNumber)) return false;
        if (gst == null) {
            if (other.gst != null) return false;
        } else if (!gst.equals(other.gst)) return false;
        if (rank == null) {
            if (other.rank != null) return false;
        } else if (!rank.equals(other.rank)) return false;
        if (title != other.title) return false;
        if (titleDesc == null) {
            if (other.titleDesc != null) return false;
        } else if (!titleDesc.equals(other.titleDesc)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [title=" + title + ", titleDesc=" + titleDesc + ", rank=" + rank + ", employeeNumber=" + employeeNumber + ", abn=" + abn + ", gst="
               + gst + ", toString()=" + super.toString() + "]";
    }

}
