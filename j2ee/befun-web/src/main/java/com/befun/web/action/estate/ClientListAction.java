package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.profile.ApartmentInterestListItem;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientPreference;
import com.befun.domain.profile.FloorplanInterestListItem;
import com.befun.domain.profile.InterestList;
import com.befun.service.estate.ApartmentService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.profile.InterestListService;
import com.befun.service.query.profile.ClientQueryCondition;
import com.befun.web.action.BaseAction;
import com.befun.web.view.converter.ApartmentConverter;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.FloorplanConverter;
import com.befun.web.view.profile.ApartmentInterestListItemView;
import com.befun.web.view.profile.ClientView;
import com.befun.web.view.profile.FloorplanInterestListItemView;
import com.befun.web.view.profile.InterestListView;
import com.befun.web.view.profile.converter.ApartmentInterestListItemConverter;
import com.befun.web.view.profile.converter.ClientConverter;
import com.befun.web.view.profile.converter.ClientPreferenceConverter;
import com.befun.web.view.profile.converter.FloorplanInterestListItemConverter;
import com.befun.web.view.profile.converter.InterestListConverter;

@Controller("ClientListAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ClientListAction extends BaseAction {

    private static final long serialVersionUID = 7013142247658129228L;

    private Long clientId;

    private ClientView client;

    private List<ClientView> clients;

    private InterestListView interestList;

    private ClientQueryCondition qc = new ClientQueryCondition();

    private ClientConverter converter = ConverterFactory.getConverter(Client.class);

    private ClientPreferenceConverter preferenceConverter = ConverterFactory.getConverter(ClientPreference.class);

    private InterestListConverter interestListConverter = ConverterFactory.getConverter(InterestList.class);

    private ApartmentInterestListItemConverter apartmentILItemConverter = ConverterFactory.getConverter(ApartmentInterestListItem.class);

    private FloorplanInterestListItemConverter floorplanILItemConverter = ConverterFactory.getConverter(FloorplanInterestListItem.class);

    private ApartmentConverter apartmentConverter = ConverterFactory.getConverter(Apartment.class);

    private FloorplanConverter floorplanConverter = ConverterFactory.getConverter(Floorplan.class);

    @Resource
    @Qualifier("InterestListService")
    private InterestListService interestListService;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService apartmentService;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService floorplanService;

    public String viewMineClients() {
        Long currentEmployeeId = this.getCurrentProfile().getId();
        qc.setCurrentEmployeeId(currentEmployeeId);
        qc.getOrderBy().add(Order.desc("lastActiveDate"));

        List<Client> rs = clientService.query(qc);
        clients = new ArrayList<ClientView>();
        ClientView v = null;
        ClientPreference cp = null;
        for (Client c : rs) {
            v = converter.convertToView(c);
            cp = c.getPreference();
            if (cp != null) {
                v.setPreference(preferenceConverter.convertToView(cp));
            }
            clients.add(v);
        }
        return SUCCESS;
    }

    public String viewClientDetail() {
        // Long clientId = this.getCurrentClientId();
        if (!isCurrentSaleOfClient(clientId)) {
            this.addActionError("You are not the current sale of this client!");
            return SUCCESS;
        }
        Client c = clientService.get(clientId);
        if (c == null) {
            return SUCCESS;
        }
        client = converter.convertToView(c);
        ClientPreference cp = c.getPreference();
        if (cp != null) {
            client.setPreference(preferenceConverter.convertToView(cp));
        }
        return SUCCESS;
    }

    public String viewInterestList() {
        // Long clientId = this.getCurrentClientId();
        List<InterestList> lists = interestListService.queryByClientFetchItem(this.clientId);
        InterestList il = null;
        if (lists.size() == 0) {
            il = interestListService.createForClient(this.clientId);
            this.interestList = interestListConverter.convertToView(il);
            return SUCCESS;
        }
        il = lists.get(0);
        this.interestList = interestListConverter.convertToView(il);
        List<ApartmentInterestListItem> apartments = il.getApartments();
        List<ApartmentInterestListItemView> apViews = new ArrayList<ApartmentInterestListItemView>();
        ApartmentInterestListItemView apv = null;
        for (ApartmentInterestListItem a : apartments) {
            apv = apartmentILItemConverter.convertToView(a);
            Apartment ap = apartmentService.get(a.getPropertyId());
            if (ap != null) {
                apv.setApartment(apartmentConverter.convertToView(ap));
            }
            apViews.add(apv);
        }
        this.interestList.setApartments(apViews);

        List<FloorplanInterestListItem> floorplans = il.getFloorplans();
        List<FloorplanInterestListItemView> fpViews = new ArrayList<FloorplanInterestListItemView>();
        FloorplanInterestListItemView fpv = null;
        for (FloorplanInterestListItem f : floorplans) {
            fpv = floorplanILItemConverter.convertToView(f);
            Floorplan fp = floorplanService.get(f.getPropertyId());
            if (fp != null) {
                fpv.setFloorplan(floorplanConverter.convertToView(fp));
            }
            fpViews.add(fpv);
        }
        this.interestList.setFloorplans(fpViews);
        return SUCCESS;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public ClientView getClient() {
        return client;
    }

    public List<ClientView> getClients() {
        return clients;
    }

    public InterestListView getInterestList() {
        return interestList;
    }

    public ClientQueryCondition getQc() {
        return qc;
    }

    public void setQc(ClientQueryCondition qc) {
        this.qc = qc;
    }

}
