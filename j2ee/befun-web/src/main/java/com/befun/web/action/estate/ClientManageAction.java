package com.befun.web.action.estate;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.profile.Client;
import com.befun.web.action.BaseAction;

@Controller("ClientManageAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientManageAction extends BaseAction {

    private static final long serialVersionUID = -9024856877901046254L;

    private Long id;

    private Client client;

    public String createClientPage() {
        return SUCCESS;
    }

    public String createClient() {
        return SUCCESS;
    }

    public String createClientPage2() {
        return SUCCESS;
    }

    public String createClient2() {
        return SUCCESS;
    }

    public String viewClient() {
        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
