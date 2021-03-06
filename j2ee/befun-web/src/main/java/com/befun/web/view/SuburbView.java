package com.befun.web.view;

import java.util.ArrayList;
import java.util.List;

import com.befun.domain.estate.Suburb;
import com.befun.domain.estate.SuburbPolyline;

public class SuburbView extends BaseEasteView<Suburb> {

    private static final long serialVersionUID = -7550239119710508633L;

    private long projectCounts = 0;

    private Long areaId;

    private String areaName;

    //
    private String name;

    private String description;

    private String masterPlan;

    private String postCode;

    private Double longitude;

    private Double latitude;

    private Integer vacancyRate;

    private Boolean universities;

    private Boolean schools;

    private Boolean shoppingCenter;

    private Boolean train;

    private Boolean chineseCommunity;

    private List<SuburbPolyline> polylines;

    private Integer zoomLevel = 15;

    public SuburbView() {
        super();
    }

    public SuburbView(Suburb model) {
        super(model);
    }

    public SuburbView(Suburb model, long projectCounts) {
        super(model);
        this.setProjectCounts(projectCounts);
    }

    public long getProjectCounts() {
        return projectCounts;
    }

    public void setProjectCounts(long projectCounts) {
        this.projectCounts = projectCounts;
    }

    public String getLabel() {
        return this.model.getName() + ", " + this.model.getPostCode();
    }

    //

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMasterPlan() {
        return masterPlan;
    }

    public void setMasterPlan(String masterPlan) {
        this.masterPlan = masterPlan;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getVacancyRate() {
        return vacancyRate;
    }

    public void setVacancyRate(Integer vacancyRate) {
        this.vacancyRate = vacancyRate;
    }

    public Boolean getUniversities() {
        return universities;
    }

    public void setUniversities(Boolean universities) {
        this.universities = universities;
    }

    public Boolean getSchools() {
        return schools;
    }

    public void setSchools(Boolean schools) {
        this.schools = schools;
    }

    public Boolean getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(Boolean shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Boolean getChineseCommunity() {
        return chineseCommunity;
    }

    public void setChineseCommunity(Boolean chineseCommunity) {
        this.chineseCommunity = chineseCommunity;
    }

    public List<SuburbPolyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<SuburbPolyline> polylines) {
        this.polylines = polylines;
    }

    public Integer getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLvl(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public String getPolylinesString() {
        StringBuilder sb = new StringBuilder();
        if (this.polylines != null) {
            for (SuburbPolyline p : polylines) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(p.getLatitude()).append(",").append(p.getLongitude());
            }
        }
        return sb.toString();
    }

    public void setPolylinesString(String str) {
        String[] coordinates = str.split(";");
        List<SuburbPolyline> pls = new ArrayList<SuburbPolyline>();
        SuburbPolyline pl = null;
        int i = 0;
        for (String c : coordinates) {
            String[] ll = c.split(",");
            if (ll.length != 2) {
                throw new IllegalArgumentException("Invalid argument!");
            }
            String latStr = ll[0];
            String longStr = ll[1];
            Double latitude = toDouble(latStr);
            Double longitude = toDouble(longStr);
            pl = new SuburbPolyline();
            pl.setLatitude(latitude);
            pl.setLongitude(longitude);
            pl.setSeqNum(i);
            pls.add(pl);
            i++;
        }
        this.polylines = pls;
    }

    private Double toDouble(String s) {
        String ds = s.trim();
        return Double.parseDouble(ds);
    }
}
