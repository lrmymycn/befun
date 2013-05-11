package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.service.security.AuthService;
import com.befun.web.action.BaseAction;

@Controller("ChangePasswordAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ChangePasswordAction extends BaseAction {

    private static final long serialVersionUID = 155989715212153042L;

    private String newPassword;

    private String repeatNewPassword;

    @Resource
    @Qualifier("AuthService")
    private AuthService authService;

    public String changePasswordPage() {
        return SUCCESS;
    }

    public void validateChangePassword() {
        if (StringUtils.isBlank(newPassword)) {
            this.addFieldError("newPassword", "Password not correct!");
        }
        if (!newPassword.equals(repeatNewPassword)) {
            this.addFieldError("newPassword", "Password not equals Repeat password!");
        }
    }

    public String changePassword() {
        Long profileId = this.getCurrentProfile().getId();
        authService.changePassword(profileId, newPassword);
        return SUCCESS;
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
