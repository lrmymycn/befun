package com.befun.service.query.profile;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Gender;
import com.befun.domain.profile.ProfileDepartment;
import com.befun.domain.profile.ProfileRole;
import com.befun.domain.profile.RoleCode;
import com.befun.service.query.QCUtils;

public class ProfileQueryCondition extends QueryCondition {

    private static final long serialVersionUID = 1892171088100059344L;

    private String profileRoleAlias = "pr";

    private String roleAlias = "r";

    private String profileDepartmentAlias = "pd";

    private String departmentAlias = "d";

    private String username;

    private Gender gender;

    private String nameKey;

    private String phoneNumber;

    private String postcode;

    private String email;

    private Boolean enabled;

    private Boolean expired;

    private Boolean credentialsExpired;

    private Boolean locked;

    private RoleCode[] roleCodes;

    private Long[] departmentIds;

    public ProfileQueryCondition() {
        super();
    }

    public ProfileQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    public ProfileQueryCondition(String selfAlias, String profileRoleAlias, String roleAlias, String profileDepartmentAlias, String departmentAlias) {
        super(selfAlias);
        this.profileRoleAlias = profileRoleAlias;
        this.roleAlias = roleAlias;
        this.profileDepartmentAlias = profileDepartmentAlias;
        this.departmentAlias = departmentAlias;
    }

    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (StringUtils.isNotEmpty(this.username)) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "username"), this.username);
            rs.add(tmp);
        }
        if (this.gender != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "gender"), this.gender);
            rs.add(tmp);
        }
        if (this.enabled != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "enabled"), this.enabled);
            rs.add(tmp);
        }
        if (this.expired != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "expired"), this.expired);
            rs.add(tmp);
        }
        if (this.credentialsExpired != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "credentialsExpired"), this.credentialsExpired);
            rs.add(tmp);
        }
        if (this.locked != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "locked"), this.locked);
            rs.add(tmp);
        }
        if (StringUtils.isNotEmpty(this.nameKey)) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "surname"), this.nameKey, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "givenName"), this.nameKey, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "preferredName"), this.nameKey, MatchMode.ANYWHERE));
            rs.add(tmp);
        }
        if (StringUtils.isNotEmpty(this.phoneNumber)) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "mobileNumber"), this.phoneNumber, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "mobileNumber1"), this.phoneNumber, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "homePhone"), this.phoneNumber, MatchMode.ANYWHERE));
            rs.add(tmp);
        }
        if (StringUtils.isNotEmpty(this.postcode)) {
            tmp = Restrictions.or(Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "homePostcode"), this.postcode),
                                  Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "mailPostcode"), this.postcode));
            rs.add(tmp);
        }
        if (StringUtils.isNotEmpty(this.email)) {
            tmp = Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "email"), this.email, MatchMode.ANYWHERE);
            rs.add(tmp);
        }
        if (this.roleCodes != null && this.roleCodes.length > 0) {
            boolean valid = true;
            for (RoleCode r : this.roleCodes) {
                if (r == null) {
                    valid = false;
                }
            }
            if (valid) {
                DetachedCriteria dc = DetachedCriteria.forClass(ProfileRole.class, this.getProfileRoleAlias());
                dc.createAlias(QCUtils.generatePropertyName(getProfileRoleAlias(), "role"), this.getRoleAlias());
                tmp = Restrictions.eqProperty(QCUtils.generatePropertyName(this.getProfileRoleAlias(), "profile.id"),
                                              QCUtils.generatePropertyName(this.getSelfAlias(), "id"));
                dc.add(tmp);
                tmp = Restrictions.in(QCUtils.generatePropertyName(this.getRoleAlias(), "code"), this.roleCodes);
                dc.add(tmp);

                dc.setProjection(Projections.property(QCUtils.generatePropertyName(this.getProfileRoleAlias(), "id")));
                tmp = Subqueries.exists(dc);
                rs.add(tmp);
            }
        }
        if (this.departmentIds != null && this.departmentIds.length > 0) {
            DetachedCriteria dc = DetachedCriteria.forClass(ProfileDepartment.class, this.getProfileDepartmentAlias());
            tmp = Restrictions.eqProperty(QCUtils.generatePropertyName(this.getProfileDepartmentAlias(), "profile.id"),
                                          QCUtils.generatePropertyName(this.getSelfAlias(), "id"));
            dc.add(tmp);
            tmp = Restrictions.in(QCUtils.generatePropertyName(this.getProfileDepartmentAlias(), "department.id"), this.departmentIds);
            dc.add(tmp);
            
            dc.setProjection(Projections.property(QCUtils.generatePropertyName(this.getProfileDepartmentAlias(), "id")));
            tmp = Subqueries.exists(dc);
            rs.add(tmp);
        }
        return rs;
    }

    public String getProfileRoleAlias() {
        return profileRoleAlias;
    }

    public void setProfileRoleAlias(String profileRoleAlias) {
        this.profileRoleAlias = profileRoleAlias;
    }

    public String getRoleAlias() {
        return roleAlias;
    }

    public void setRoleAlias(String roleAlias) {
        this.roleAlias = roleAlias;
    }

    public String getProfileDepartmentAlias() {
        return profileDepartmentAlias;
    }

    public void setProfileDepartmentAlias(String profileDepartmentAlias) {
        this.profileDepartmentAlias = profileDepartmentAlias;
    }

    public String getDepartmentAlias() {
        return departmentAlias;
    }

    public void setDepartmentAlias(String departmentAlias) {
        this.departmentAlias = departmentAlias;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public RoleCode[] getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(RoleCode[] roleCodes) {
        this.roleCodes = roleCodes;
    }

    public Long[] getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(Long[] departmentIds) {
        this.departmentIds = departmentIds;
    }

}
