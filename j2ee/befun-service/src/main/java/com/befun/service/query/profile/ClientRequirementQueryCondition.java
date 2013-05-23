package com.befun.service.query.profile;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class ClientRequirementQueryCondition extends QueryCondition {

    private static final long serialVersionUID = -1450128265850871256L;

    private Long clientId;

    public ClientRequirementQueryCondition() {
        super();
    }

    public ClientRequirementQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.clientId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "client.id"), this.clientId);
            rs.add(tmp);
        }
        return rs;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "ClientRequirementQueryCondition [clientId=" + clientId + "]";
    }

}
