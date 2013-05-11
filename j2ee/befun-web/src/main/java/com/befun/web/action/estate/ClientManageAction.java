package com.befun.web.action.estate;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientPreference;
import com.befun.domain.profile.Employee;
import com.befun.domain.profile.RoleCode;
import com.befun.service.profile.ClientPreferenceService;
import com.befun.service.profile.InterestListService;
import com.befun.web.action.BaseAction;

@Controller("ClientManageAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientManageAction extends BaseAction {

    private static final long serialVersionUID = -9024856877901046254L;

    private static String[] IGNORE_PROPS = { "lastActiveDate", "preference" };

    private Long clientId;

    private Client client = new Client();

    private ClientPreference preference = new ClientPreference();

    @Resource
    @Qualifier("InterestListService")
    private InterestListService interestListService;

    @Resource
    @Qualifier("ClientPreferenceService")
    private ClientPreferenceService clientPreferenceService;

    public String createClient() {
        if (!this.containsAnyRoles(RoleCode.SALE, RoleCode.SUPER)) {
            this.addActionError("You are not a sale!");
            return SUCCESS;
        }
        Employee currentEmployee = this.getCurrentEmployee();
        if (currentEmployee == null) {
            this.addActionError("Current sale not found!");
            return SUCCESS;
        }
        client.setCurrentEmployee(currentEmployee);
        this.clientService.save(client);
        return SUCCESS;
    }

    public void validateUpdateClient() {
        if (this.client.getId() == null) {
            this.addActionError("Client lost id!");
        }
    }

    public String updateClient() {
        if (!isCurrentSaleOfClient(this.client.getId())) {
            this.addActionError("You are not the current sale of this client!");
            return SUCCESS;
        }
        this.clientService.update(client, IGNORE_PROPS);
        return SUCCESS;
    }

    public String saveOrUpdateClient() {
        if (this.client.getId() == null) {
            return this.createClient();
        }
        return this.updateClient();
    }

    public void validateUpdateClientPreference() {
        if (this.clientId == null) {
            this.addFieldError("clientId", "Please indicate clientId!");
        }
    }

    public String updateClientPreference() {
        if (!isCurrentSaleOfClient(this.clientId)) {
            this.addActionError("You are not the current sale of this client!");
            return SUCCESS;
        }
        Client c = this.clientService.get(this.clientId);
        if (c == null) {
            this.addActionError("Client not found!");
        }
        if (c.getPreference() != null) {
            preference.setId(c.getPreference().getId());
        }
        c.setPreference(preference);
        this.clientService.update(c, new String[] { "lastActiveDate" });
        return SUCCESS;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientPreference getPreference() {
        return preference;
    }

    public void setPreference(ClientPreference preference) {
        this.preference = preference;
    }

}
