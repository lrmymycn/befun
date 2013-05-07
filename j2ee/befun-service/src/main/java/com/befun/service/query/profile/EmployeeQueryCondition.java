package com.befun.service.query.profile;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class EmployeeQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 1892171088100059344L;

    private ProfileQueryCondition proQC = new ProfileQueryCondition();

    private String title;

    private Integer rank;

    private String employeeNumber;

    private String abn;

    private String gst;

    public EmployeeQueryCondition() {
        super();
    }

    public EmployeeQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.proQC != null) {
            List<Criterion> proCrs = this.proQC.getCriterions();
            rs.addAll(proCrs);
        }
        if (this.title != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "title"), this.title);
            rs.add(tmp);
        }
        if (this.rank != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "rank"), this.rank);
            rs.add(tmp);
        }
        if (this.employeeNumber != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "employeeNumber"), this.employeeNumber);
            rs.add(tmp);
        }
        if (this.abn != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "abn"), this.abn);
            rs.add(tmp);
        }
        if (this.gst != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "gst"), this.gst);
            rs.add(tmp);
        }
        return rs;
    }

    public ProfileQueryCondition getProQC() {
        return proQC;
    }

    public void setProQC(ProfileQueryCondition proQC) {
        this.proQC = proQC;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    public String toString() {
        return "EmployeeQueryCondition [proQC=" + proQC + ", title=" + title + ", rank=" + rank + ", employeeNumber=" + employeeNumber + ", abn=" + abn
               + ", gst=" + gst + ", toString()=" + super.toString() + "]";
    }

}
