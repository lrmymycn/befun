package com.befun.web.action.admin.profile;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.web.action.BaseAction;

@Controller("ChangePasswordAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ChangePasswordAction extends BaseAction {

    private static final long serialVersionUID = 155989715212153042L;

    private String oldPassword;

    private Long profileId;

    private String newPassword;

    private String repeatNewPassword;

    public String changePasswordPage() {
        return SUCCESS;
    }

    public String changePassword() {
        return SUCCESS;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatNewPassword() {
        return repeatNewPassword;
    }

    public void setRepeatNewPassword(String repeatNewPassword) {
        this.repeatNewPassword = repeatNewPassword;
    }

}
