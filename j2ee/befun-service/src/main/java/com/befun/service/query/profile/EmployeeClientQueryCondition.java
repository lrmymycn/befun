package com.befun.service.query.profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class EmployeeClientQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 1892171088100059344L;

    private Long employeeId;

    private Long clientId;

    private Date startDate;

    private Date endDate;

    private Boolean activeCase;

    public EmployeeClientQueryCondition() {
        super();
    }

    public EmployeeClientQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.employeeId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "employee.id"), this.employeeId);
            rs.add(tmp);
        }
        if (this.clientId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "client.id"), this.clientId);
            rs.add(tmp);
        }
        if (this.startDate != null) {
            tmp = Restrictions.ge(QCUtils.generatePropertyName(this.getSelfAlias(), "startDate"), this.startDate);
            rs.add(tmp);
        }
        if (this.endDate != null) {
            tmp = Restrictions.le(QCUtils.generatePropertyName(this.getSelfAlias(), "endDate"), this.endDate);
            rs.add(tmp);
        }
        return rs;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActiveCase() {
        return activeCase;
    }

    public void setActiveCase(Boolean activeCase) {
        this.activeCase = activeCase;
    }

    @Override
    public String toString() {
        return "EmployeeClientQueryCondition [employeeId=" + employeeId + ", clientId=" + clientId + ", startDate=" + startDate + ", endDate=" + endDate
               + ", activeCase=" + activeCase + ", toString()=" + super.toString() + "]";
    }

}
