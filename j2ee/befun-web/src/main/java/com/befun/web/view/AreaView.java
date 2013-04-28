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

    private Integer zoomLevel = 12;

    public AreaView() {
        super();
    }

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

    public Integer getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLvl(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public String getPolylinesString() {
        StringBuilder sb = new StringBuilder();
        if (this.polylines != null) {
            for (AreaPolyline p : polylines) {
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
        List<AreaPolyline> pls = new ArrayList<AreaPolyline>();
        AreaPolyline pl = null;
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
            pl = new AreaPolyline();
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
