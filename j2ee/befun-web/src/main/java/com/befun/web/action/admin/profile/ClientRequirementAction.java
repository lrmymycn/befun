package com.befun.web.action.admin.profile;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientRequirement;
import com.befun.service.IBaseService;
import com.befun.service.profile.ClientRequirementService;
import com.befun.service.query.profile.ClientQueryCondition;
import com.befun.service.query.profile.ClientRequirementQueryCondition;

@Controller("AdminClientRequirementAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientRequirementAction extends ProfileCRUDAction<ClientRequirement> {

    private static final long serialVersionUID = -8310075873549607381L;

    private static final String[] UPDATE_IGNORED_PROPS = { "lastActiveDate", "preference" };

    private ClientRequirementQueryCondition qc = new ClientRequirementQueryCondition();

    private List<Client> paramClients;

    @Resource
    @Qualifier("ClientRequirementService")
    private ClientRequirementService service;
    
    public ClientRequirementAction(){
        this.model = new ClientRequirement();
    }

    @Override
    public void prepare() throws Exception {

    }

    public void prepareDemandById() {
        ClientQueryCondition qc = new ClientQueryCondition();
        qc.setEnabled(null);
        this.paramClients = this.clientService.query(qc);
    }

    public void prepareCreatePage() {
        ClientQueryCondition qc = new ClientQueryCondition();
        qc.setEnabled(null);
        this.paramClients = this.clientService.query(qc);
    }
    
    public void prepareDemand() {
        ClientQueryCondition qc = new ClientQueryCondition();
        qc.setEnabled(null);
        this.paramClients = this.clientService.query(qc);
    }
    
    public List<Client> getParamClients() {
        return paramClients;
    }

    @Override
    public QueryCondition getQc() {
        return qc;
    }

    public void setModel(ClientRequirement model) {
        this.model = model;
    }

    public ClientRequirement getModel() {
        return this.model;
    }

    @Override
    public IBaseService<ClientRequirement, Long> getService() {
        return service;
    }

    public String[] getUpdateIgnoredProperties() {
        return UPDATE_IGNORED_PROPS;
    }

}
