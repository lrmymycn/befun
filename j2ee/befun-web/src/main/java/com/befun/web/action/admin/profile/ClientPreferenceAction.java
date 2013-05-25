package com.befun.web.action.admin.profile;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.ClientPreference;
import com.befun.service.IBaseService;
import com.befun.service.profile.ClientPreferenceService;

@Controller("AdminClientPreferenceAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientPreferenceAction<M extends ClientPreference> extends ProfileCRUDAction<ClientPreference> {

    private static final long serialVersionUID = 5495201659557835300L;

    @Resource
    @Qualifier("ClientPreferenceService")
    private ClientPreferenceService service;

    public ClientPreferenceAction() {
        this.model = new ClientPreference();
    }

    public void setModel(ClientPreference model) {
        this.model = model;
    }

    public ClientPreference getModel() {
        return this.model;
    }

    @Override
    public IBaseService<ClientPreference, Long> getService() {
        return this.service;
    }

    @Override
    public void prepare() throws Exception {

    }

    @Override
    public QueryCondition getQc() {
        return null;
    }
}
