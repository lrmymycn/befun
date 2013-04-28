package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Floorplan;
import com.befun.service.estate.FloorplanService;
import com.befun.web.action.BaseAction;

@Controller("CompareAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompareAction extends BaseAction {

    private static final long serialVersionUID = 5353027870557787231L;

    private Long id;

    private List<Floorplan> rs;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService service;

    public String addToCompareList() {
        List<Long> compareIds = this.getCompareList();
        compareIds.add(this.id);
        return SUCCESS;
    }

    public String removeFromCompareList() {
        List<Long> compareIds = this.getCompareList();
        compareIds.remove(this.id);
        return SUCCESS;
    }

    public String compareFloorplan() {
        List<Long> compareIds = this.getCompareList();
        rs = this.service.get(compareIds.toArray(new Long[] {}));
        return SUCCESS;
    }

    public List<Long> getCompareList() {
        List<Long> compareIds = (List<Long>) this.getRequest().getSession().getAttribute("compareList");
        if (compareIds == null) {
            compareIds = new ArrayList<Long>();
            this.getRequest().getSession().setAttribute("compareList", compareIds);
        }
        return compareIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Floorplan> getRs() {
        return rs;
    }

}
