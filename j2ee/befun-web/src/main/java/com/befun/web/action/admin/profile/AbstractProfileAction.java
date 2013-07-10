package com.befun.web.action.admin.profile;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;
import org.jmesa.limit.Action;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Gender;
import com.befun.domain.profile.Profile;
import com.befun.domain.profile.ProfileType;
import com.befun.domain.profile.RoleCode;
import com.befun.service.profile.ProfileService;
import com.befun.service.query.QCUtils;
import com.befun.service.query.profile.ProfileQueryCondition;
import com.befun.web.utils.JmesaUtils;
import com.opensymphony.xwork2.Preparable;

public abstract class AbstractProfileAction<M extends Profile> extends ProfileCRUDAction<M> implements Preparable {

    private static final long serialVersionUID = 5495201659557835300L;

    private String tableName;

    private ProfileQueryCondition qc = new ProfileQueryCondition();

    private String repeatPassword;

    private static Gender[] paramGenders = Gender.values();

    private static RoleCode[] paramRoles = RoleCode.values();

    private static ProfileType[] paramTypes = ProfileType.values();

    @Resource
    @Qualifier("ProfileService")
    protected ProfileService profileService;

    @Resource
    @Qualifier(value = "BefunPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    public void prepare() {
        this.pn = this.getPageNum(getTableName());
        this.ps = this.getPageSize(getTableName());
    }

    protected long getPageNum(String tableName) {
        long rs = 1;
        String str = JmesaUtils.getJmesaParam(this.getRequest(), Action.PAGE, tableName);
        if (!StringUtils.isBlank(str)) {
            rs = Long.parseLong(str);
        }
        return rs;
    }

    protected int getPageSize(String tableName) {
        int rs = 20;
        String str = JmesaUtils.getJmesaParam(this.getRequest(), Action.MAX_ROWS, tableName);
        if (!StringUtils.isBlank(str)) {
            rs = Integer.parseInt(str);
        }
        return rs;
    }

    public String getTableName() {
        if (StringUtils.isBlank(this.tableName)) {
            this.tableName = this.getRequest().getParameter("tableName");
        }
        return tableName;
    }

    public void validateCreate() {
        if (StringUtils.isBlank(model.getPassword())) {
            this.addFieldError("model.password", "Password not correct!");
        }
        if (!model.getPassword().equals(repeatPassword)) {
            this.addFieldError("model.password", "Password not equals Repeat password!");
        }
    }

    @Override
    public String create() {
        if (model.getPassword() != null) {
            String encodedPassword = this.passwordEncoder.encode(model.getPassword());
            this.model.setPassword(encodedPassword);
        }
        if (this.profileService.exists(model.getUsername())) {
            this.addFieldError("model.username", "Username exists!");
            return INPUT;
        }
        return super.create();
    }

    public void validateRemove() {
        this.defaultWriteAccessCheck();
    }

    public void validateUpdate() {
        if (StringUtils.isBlank(model.getPassword())) {
            this.addFieldError("model.password", "Password not correct!");
            return;
        }
        if (!model.getPassword().equals(repeatPassword)) {
            this.addFieldError("model.password", "Password not equals Repeat password!");
            return;
        }
    }

    @Override
    public String update() {
        if (model.getPassword() != null) {
            String encodedPassword = this.passwordEncoder.encode(model.getPassword());
            this.model.setPassword(encodedPassword);
        }
        return super.update();
    }

    public void validateCreateOrUpdate() {
        if (StringUtils.isBlank(model.getPassword())) {
            this.addFieldError("model.password", "Password not correct!");
            return;
        }
        if (!model.getPassword().equals(repeatPassword)) {
            this.addFieldError("model.password", "Password not equals Repeat password!");
            return;
        }
    }

    public String demand() {
        String lastModifiedDateProp = QCUtils.generatePropertyName(qc.getSelfAlias(), "modification.lastModifiedDate");
        this.getQc().getOrderBy().add(Order.desc(lastModifiedDateProp));
        String creationDateProp = QCUtils.generatePropertyName(qc.getSelfAlias(), "modification.creationDate");
        this.getQc().getOrderBy().add(Order.desc(creationDateProp));
        return super.demand();
    }

    public void validateEnable() {
        this.defaultWriteAccessCheck();
    }

    public String enable() {
        try {
            this.profileService.enable(this.id);
            this.addActionMessage("Enabled!");
        } catch (Exception ex) {
            String errMsg = "Enable failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void validateDisable() {
        this.defaultWriteAccessCheck();
    }

    public String disable() {
        try {
            this.profileService.disable(this.id);
            this.addActionMessage("Disabled!");
        } catch (Exception ex) {
            String errMsg = "Disable failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void validateExpire() {
        this.defaultWriteAccessCheck();
    }

    public String expire() {
        try {
            this.profileService.expire(this.id);
            this.addActionMessage("Expired!");
        } catch (Exception ex) {
            String errMsg = "Expire failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void validateRenewal() {
        this.defaultWriteAccessCheck();
    }

    public String renewal() {
        try {
            this.profileService.renewal(this.id);
            this.addActionMessage("Renewal!");
        } catch (Exception ex) {
            String errMsg = "Renewal failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void validateLock() {
        this.defaultWriteAccessCheck();
    }

    public String lock() {
        try {
            this.profileService.lock(this.id);
            this.addActionMessage("Locked!");
        } catch (Exception ex) {
            String errMsg = "Locke failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void validateUnlock() {
        this.defaultWriteAccessCheck();
    }

    public String unlock() {
        try {
            this.profileService.unlock(this.id);
            this.addActionMessage("Unlocked!");
        } catch (Exception ex) {
            String errMsg = "Unlocke failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public Gender[] getParamGenders() {
        return paramGenders;
    }

    public RoleCode[] getParamRoles() {
        return paramRoles;
    }

    public ProfileType[] getParamTypes() {
        return paramTypes;
    }

    public void setQc(ProfileQueryCondition qc) {
        this.qc = qc;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public M getModel() {
        return this.model;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    private boolean defaultWriteAccessCheck() {
        if (this.containsAnyRoles(RoleCode.SUPER, RoleCode.DATA_ADMIN)) {
            return true;
        }
        Profile currentProfile = this.getCurrentProfile();
        if (currentProfile != null && currentProfile.getId() != null && currentProfile.getId().equals(this.id)) {
            return true;
        }
        this.addActionError("Access denied");
        return false;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
