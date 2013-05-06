package com.befun.web.action.estate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Apartment;
import com.befun.service.estate.ApartmentService;
import com.befun.web.action.BaseAction;

@Controller("CompareAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompareAction extends BaseAction {

    private static final String COOKIE_FLOORPLANS_COMPARELIST = "floorplans";

    private static final long serialVersionUID = 5353027870557787231L;

    private String compareIdsStr;

    private List<Apartment> rs;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService service;

    public String compareFloorplan() {
        List<Long> compareIds = this.getCompareList();
        if (compareIds.size() > 0) {
            rs = this.service.get(compareIds.toArray(new Long[] {}));
        } else {
            this.addActionMessage("No apartment selected!");
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
                    System.out.println(value);
                    value = URLDecoder.decode(value, "UTF-8");
                    o = JSONUtil.deserialize(value);
                    List<?> os = (List<?>) (o);
                    for (Object jo : os) {
                        HashMap<?, ?> ho = (HashMap<?, ?>) jo;
                        Long id = (Long) ho.get("id");
                        if (id != null) {
                            compareIds.add(id);
                        }
                    }
                } catch (JSONException e) {
                    this.log.debug(e);
                } catch (UnsupportedEncodingException e) {
                    this.log.debug(e);
                }
            }
        }
        return compareIds;
    }

    public List<Apartment> getRs() {
        return rs;
    }

    public String getCompareIdsStr() {
        return compareIdsStr;
    }

    public void setCompareIdsStr(String compareIdsStr) {
        this.compareIdsStr = compareIdsStr;
    }

}
