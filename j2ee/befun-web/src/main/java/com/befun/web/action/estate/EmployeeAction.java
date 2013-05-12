package com.befun.web.action.estate;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.profile.ApartmentInterestListItem;
import com.befun.domain.profile.FloorplanInterestListItem;
import com.befun.domain.profile.InterestList;
import com.befun.service.profile.ApartmentInterestListItemService;
import com.befun.service.profile.EmployeeService;
import com.befun.service.profile.FloorplanInterestListItemService;
import com.befun.service.profile.InterestListService;
import com.befun.web.action.BaseAction;

@Controller("EmployeeAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeAction extends BaseAction {

    private static final long serialVersionUID = -7931972692493916548L;

    private Long clientId;

    private Long propertyId;

    private Long interestListItemId;

    @Resource
    @Qualifier("EmployeeService")
    private EmployeeService service;

    @Resource
    @Qualifier("InterestListService")
    private InterestListService interestListService;

    @Resource
    @Qualifier("ApartmentInterestListItemService")
    private ApartmentInterestListItemService apartmentILItemService;

    @Resource
    @Qualifier("FloorplanInterestListItemService")
    private FloorplanInterestListItemService floorplanILItemService;

    public String selectClient() {
        if (!isCurrentSaleOfClient(this.clientId)) {
            this.addActionError("You are not the current sale of this client!");
            return SUCCESS;
        }
        this.setSessionProperty("currentClient", this.clientId);
        return SUCCESS;
    }

    public void validateAddAppartmentToList() {
        if (this.propertyId == null) {
            this.addActionError("Please select a apartment!");
        }
    }

    public String addAppartmentToList() {
        Long currentClientId = this.getCurrentClientId();
        if (currentClientId == null) {
            this.addActionError("Please select a client firstly!");
        }
        InterestList il = getInterestListOfClient(currentClientId);
        ApartmentInterestListItem item = new ApartmentInterestListItem();
        item.setInterestList(il);
        item.setPropertyId(this.propertyId);
        apartmentILItemService.save(item);
        return SUCCESS;
    }

    public String removeApartmentItem() {
        ApartmentInterestListItem item = apartmentILItemService.getFetchList(this.interestListItemId);
        if (item == null) {
            return SUCCESS;
        }
        if (!isCurrentSaleOfClient(item.getInterestList().getClientId())) {
            this.addActionError("You are not the current sale of this client!");
        }
        apartmentILItemService.deleteObject(item);
        return SUCCESS;
    }

    public void validateAddFloorplanToList() {
        if (this.propertyId == null) {
            this.addActionError("Please select a floorplan!");
        }
    }

    public String addFloorplanToList() {
        Long currentClientId = this.getCurrentClientId();
        if (currentClientId == null) {
            this.addActionError("Please select a client firstly!");
        }
        InterestList il = getInterestListOfClient(currentClientId);
        FloorplanInterestListItem item = new FloorplanInterestListItem();
        item.setInterestList(il);
        item.setPropertyId(this.propertyId);
        floorplanILItemService.save(item);
        return SUCCESS;
    }

    public String removeFloorplanFromList() {
        FloorplanInterestListItem item = floorplanILItemService.getFetchList(this.interestListItemId);
        if (item == null) {
            return SUCCESS;
        }
        if (!isCurrentSaleOfClient(item.getInterestList().getClientId())) {
            this.addActionError("You are not the current sale of this client!");
        }
        floorplanILItemService.deleteObject(item);
        return SUCCESS;
    }

    private InterestList getInterestListOfClient(Long id) {
        List<InterestList> lists = interestListService.queryByClientFetchItem(id);
        InterestList il = null;
        if (lists.size() == 0) {
            il = interestListService.createForClient(id);
        } else {
            il = lists.get(0);
        }
        return il;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getInterestListItemId() {
        return interestListItemId;
    }

    public void setInterestListItemId(Long interestListItemId) {
        this.interestListItemId = interestListItemId;
    }

}
