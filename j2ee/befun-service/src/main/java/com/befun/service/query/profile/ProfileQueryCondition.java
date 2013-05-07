package com.befun.service.query.profile;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Gender;
import com.befun.service.query.QCUtils;

public class ProfileQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 1892171088100059344L;

    private String username;

    private Gender gender;

    private String nameKey;

    private String phoneNumber;

    private String postcode;

    private String email;

    public ProfileQueryCondition() {
        super();
    }

    public ProfileQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.username != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "username"), this.username);
            rs.add(tmp);
        }
        if (this.gender != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "gender"), this.gender);
            rs.add(tmp);
        }
        if (this.nameKey != null) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "surname"), this.nameKey, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "givenName"), this.nameKey, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "preferredName"), this.nameKey, MatchMode.ANYWHERE));
            rs.add(tmp);
        }
        if (this.phoneNumber != null) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "mobileNumber"), this.phoneNumber, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "mobileNumber1"), this.phoneNumber, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "homePhone"), this.phoneNumber, MatchMode.ANYWHERE));
            rs.add(tmp);
        }
        if (this.postcode != null) {
            tmp = Restrictions.or(Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "homePostcode"), this.postcode),
                                  Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "mailPostcode"), this.postcode));
            rs.add(tmp);
        }
        if (this.email != null) {
            tmp = Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "email"), this.email, MatchMode.ANYWHERE);
            rs.add(tmp);
        }
        return rs;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
