package com.befun.web.view;

import java.util.ArrayList;
import java.util.List;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.AreaPolyline;

public class AreaView extends BaseView<Area> {

    private static final long serialVersionUID = 5757966846983558308L;

    private long projectCounts = 0;

    private List<SuburbView> suburbs = new ArrayList<SuburbView>();

    //
    private String name;

    private String description;

    private Double longitude;

    private Double latitude;

    private List<AreaPolyline> polylines;

    public AreaView(Area model) {
        super(model);
    }

    public AreaView(Area model, long projectCounts) {
        super(model);
        this.setProjectCounts(projectCounts);
    }

    public long getProjectCounts() {
        return projectCounts;
    }

    public void setProjectCounts(long projectCounts) {
        this.projectCounts = projectCounts;
    }

    public List<SuburbView> getSuburbs() {
        return suburbs;
    }

    //

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

    public List<AreaPolyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<AreaPolyline> polylines) {
        this.polylines = polylines;
    }

}
