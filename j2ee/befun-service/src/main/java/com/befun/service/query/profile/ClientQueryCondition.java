package com.befun.service.query.profile;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.ClientStatus;
import com.befun.domain.profile.ClientTitle;
import com.befun.service.query.QCUtils;

public class ClientQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 1892171088100059344L;

    private ProfileQueryCondition proQC = new ProfileQueryCondition();

    private ClientTitle title;

    private ClientStatus status;

    private Integer purchaseType;

    private Long currentEmployeeId;

    public ClientQueryCondition() {
        super();
    }

    public ClientQueryCondition(String selfAlias) {
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
        if (this.status != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "status"), this.status);
            rs.add(tmp);
        }
        if (this.purchaseType != null) {
            String propertyName = null;
            if (this.purchaseType == 0) {
                propertyName = "purchaseTypeFirst";
            } else if (this.purchaseType == 1) {
                propertyName = "purchaseTypeOwner";
            } else if (this.purchaseType == 2) {
                propertyName = "purchaseTypeInverstor";
            } else if (this.purchaseType == 3) {
                propertyName = "purchaseTypeStudent";
            } else if (this.purchaseType == 4) {
                propertyName = "purchaseTypeOther";
            } else if (this.purchaseType == 5) {
                propertyName = "purchaseType1";
            } else if (this.purchaseType == 6) {
                propertyName = "purchaseType2";
            } else if (this.purchaseType == 7) {
                propertyName = "purchaseType3";
            } else if (this.purchaseType == 8) {
                propertyName = "purchaseType4";
            }
            if (propertyName != null) {
                tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), propertyName), true);
                rs.add(tmp);
            }
        }
        if (this.currentEmployeeId != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "currentEmployee.id"), this.currentEmployeeId);
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

    public ClientTitle getTitle() {
        return title;
    }

    public void setTitle(ClientTitle title) {
        this.title = title;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public Integer getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Integer purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Long getCurrentEmployeeId() {
        return currentEmployeeId;
    }

    public void setCurrentEmployeeId(Long currentEmployeeId) {
        this.currentEmployeeId = currentEmployeeId;
    }

    @Override
    public String toString() {
        return "ClientQueryCondition [proQC=" + proQC + ", title=" + title + ", status=" + status + ", purchaseType=" + purchaseType + ", currentEmployeeId="
               + currentEmployeeId + ", toString()=" + super.toString() + "]";
    }

}
