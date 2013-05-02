package com.befun.web.action.admin.profile;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.profile.Client;
import com.befun.domain.profile.Profile;
import com.befun.service.security.AuthService;
import com.befun.web.action.BaseAction;

@Controller("UserAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserAction extends BaseAction {

    private static final long serialVersionUID = 5495201659557835300L;

    @Resource
    @Qualifier("AuthService")
    private AuthService authService;

    private Profile profile;

    private Client client;

    private String profileId;

    private String password;

    private String repeatPassword;

    public String createProfilePage() {

        return SUCCESS;
    }

    public String createProfile() {

        return SUCCESS;
    }

    public String updateProfilePage() {
        return SUCCESS;
    }

    public String demandUserById() {
        return SUCCESS;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

}
