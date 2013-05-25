package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientRequirement;
import com.befun.domain.profile.RoleCode;
import com.befun.service.profile.ClientRequirementService;
import com.befun.service.query.profile.ClientRequirementQueryCondition;
import com.befun.web.action.BaseAction;

@Controller("ClientRequirementAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientRequirementAction extends BaseAction {

    private static final long serialVersionUID = -9024856877901046254L;

    private static String[] IGNORE_PROPS = { "client" };

    private Long id;

    private ClientRequirementQueryCondition qc = new ClientRequirementQueryCondition();

    private ClientRequirement model = new ClientRequirement();

    private List<ClientRequirement> requirements = new ArrayList<ClientRequirement>();

    @Resource
    @Qualifier("ClientRequirementService")
    private ClientRequirementService service;

    public String create() {
        if (!this.containsAnyRoles(RoleCode.SALE, RoleCode.SUPER)) {
            this.addActionError("You are not a sale!");
            return SUCCESS;
        }
        if (this.model.getClient() == null || this.model.getClient().getId() == null) {
            Long clientId = this.getCurrentClientId();
            if (clientId == null) {
                this.addActionError("Current clientId not found!");
                return SUCCESS;
            }
            if (this.model.getClient() == null) {
                Client client = new Client();
                client.setId(clientId);
                this.model.setClient(client);
            }
        }
        try {
            this.service.save(model);
            return SUCCESS;
        } catch (Exception ex) {
            String errMsg = "Create failure! Object:" + this.model;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
    }

    public void validateUpdate() {
        if (this.model.getId() == null) {
            this.addActionError("ClientRequirement lost id!");
        }
    }

    public String update() {
        if (!isCurrentSaleOfClient(this.model.getClient().getId())) {
            this.addActionError("You are not the current sale of this client!");
            return SUCCESS;
        }
        try {
            this.service.update(this.model, IGNORE_PROPS);
            return SUCCESS;
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + this.model;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
    }

    public String createOrUpdate() {
        if (this.model.getId() == null) {
            return this.create();
        }
        return this.update();
    }

    public void validateDemand() {
        if (this.qc.getClientId() == null) {
            this.addActionError("You should indicate qc.clientId!");
        }
    }

    public String demand() {
        try {
            this.requirements = this.service.query(qc);
            return SUCCESS;
        } catch (Exception ex) {
            String errMsg = "Demand failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
    }

    public void validateDemandById() {
        if (this.id == null) {
            this.addActionError("You should indicate id!");
        }
    }

    public String demandById() {
        try {
            this.model = this.service.get(this.getId());
            if (this.model == null) {
                this.addActionMessage("ClientRequirement with id: " + this.getId() + " not found!");
            }
            return SUCCESS;
        } catch (Exception ex) {
            String errMsg = "DemandById failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
    }

    public String remove() {
        try {
            this.service.delete(this.id);
            this.addActionMessage("Remove successfully! ID:" + this.id);
            return SUCCESS;
        } catch (Exception ex) {
            String errMsg = "Delete failure! Id:" + id;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
    }

    public ClientRequirementQueryCondition getQc() {
        return qc;
    }

    public void setQc(ClientRequirementQueryCondition qc) {
        this.qc = qc;
    }

    public ClientRequirement getModel() {
        return model;
    }

    public void setModel(ClientRequirement model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ClientRequirement> getRequirements() {
        return requirements;
    }

}
