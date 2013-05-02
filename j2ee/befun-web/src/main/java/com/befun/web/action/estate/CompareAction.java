package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
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

    private static final String COOKIE_FLOORPLANS_COMPARELIST = "floorplans";

    private static final long serialVersionUID = 5353027870557787231L;

    private String compareIdsStr;

    private List<Floorplan> rs;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService service;

    public String compareFloorplan() {
        List<Long> compareIds = this.getCompareList();
        if (compareIds.size() > 0) {
            rs = this.service.get(compareIds.toArray(new Long[] {}));
        } else {
            this.addActionMessage("No floorplan selected!");
        }
        return SUCCESS;
    }

    public List<Long> getCompareList() {
        List<Long> compareIds = new ArrayList<Long>();
        Cookie[] cookies = this.getRequest().getCookies();
        for (Cookie ck : cookies) {
            if (COOKIE_FLOORPLANS_COMPARELIST.equals(ck.getName())) {
                String value = ck.getValue();
                Object o;
                try {
                    o = JSONUtil.deserialize(value);
                    List<?> os = (List<?>) (o);
                    for (Object jo : os) {
                        HashMap<?, ?> ho = (HashMap<?, ?>) jo;
                        String idStr = (String) ho.get("id");
                        if (!StringUtils.isBlank(idStr)) {
                            try {
                                Long id = Long.parseLong(idStr);
                                compareIds.add(id);
                            } catch (NumberFormatException ne) {
                                this.log.debug("Compare list error!", ne);
                            }

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return compareIds;
    }

    public List<Floorplan> getRs() {
        return rs;
    }

    public String getCompareIdsStr() {
        return compareIdsStr;
    }

    public void setCompareIdsStr(String compareIdsStr) {
        this.compareIdsStr = compareIdsStr;
    }

}
