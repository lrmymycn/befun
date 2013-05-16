package com.befun.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.jmesa.limit.Action;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.BaseModel;
import com.befun.domain.PaginationBean;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.service.estate.AreaService;
import com.befun.service.estate.BuildingService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.estate.ProjectService;
import com.befun.service.estate.StageService;
import com.befun.service.estate.SuburbService;
import com.befun.web.action.CRUDAction;
import com.befun.web.utils.JmesaUtils;
import com.befun.web.view.BaseEasteView;
import com.befun.web.view.converter.AreaConverter;
import com.befun.web.view.converter.BuildingConverter;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.FloorplanConverter;
import com.befun.web.view.converter.ProjectConverter;
import com.befun.web.view.converter.StageConverter;
import com.befun.web.view.converter.SuburbConverter;
import com.opensymphony.xwork2.Preparable;

public abstract class AdminAction<M extends BaseModel<Long>, V extends BaseEasteView<M>> extends CRUDAction<M, V> implements Preparable {

    private static final long serialVersionUID = -4633078816479738427L;

    private String tableName;

    private List<V> views = new ArrayList<V>();

    protected AreaConverter areaConverter = ConverterFactory.getConverter(Area.class);

    protected SuburbConverter suburbConverter = ConverterFactory.getConverter(Suburb.class);

    protected ProjectConverter projectConverter = ConverterFactory.getConverter(Project.class);

    protected StageConverter stageConverter = ConverterFactory.getConverter(Stage.class);

    protected BuildingConverter buildingConverter = ConverterFactory.getConverter(Building.class);

    protected FloorplanConverter floorplanConverter = ConverterFactory.getConverter(Floorplan.class);

    @Resource
    @Qualifier("AreaService")
    protected AreaService areaService;

    @Resource
    @Qualifier("SuburbService")
    protected SuburbService suburbService;

    @Resource
    @Qualifier("ProjectService")
    protected ProjectService projectService;

    @Resource
    @Qualifier("StageService")
    protected StageService stageService;

    @Resource
    @Qualifier("BuildingService")
    protected BuildingService buildingService;

    @Resource
    @Qualifier("FloorplanService")
    protected FloorplanService floorplanService;

    public AdminAction() {
        super();
        this.pgb = new PaginationBean<V>();
        this.pgb.setModels(new ArrayList<V>(0));
    }

    public void prepare() {
        this.pn = this.getPageNum(getTableName());
        this.ps = this.getPageSize(getTableName());
    }

    public String demandAll() {
        try {
            List<M> models = this.getService().query(this.getQc());
            for (M obj : models) {
                V v = this.getConverter().convertToView(obj);
                this.views.add(v);
            }
        } catch (Exception ex) {
            String errMsg = "Demand failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public String demand() {
        try {
            prepareQueryList();
        } catch (Exception ex) {
            this.log.warn("Preapare query parameters failure!", ex);
        }
        return super.demand();
    }

    protected long getPageNum(String tableName) {
        long rs = 1;
        String str = JmesaUtils.getJmesaParam(this.getRequest(), Action.PAGE, tableName);
        if (!StringUtils.isBlank(str)) {
            rs = Long.parseLong(str);
        }
        return rs;
    }

    protected int getPageSize(String tableName) {
        int rs = 20;
        String str = JmesaUtils.getJmesaParam(this.getRequest(), Action.MAX_ROWS, tableName);
        if (!StringUtils.isBlank(str)) {
            rs = Integer.parseInt(str);
        }
        return rs;
    }

    public String getTableName() {
        if (StringUtils.isBlank(this.tableName)) {
            this.tableName = this.getRequest().getParameter("tableName");
        }
        return tableName;
    }

    public List<V> getViews() {
        return views;
    }
    
    protected void prepareQueryList() {
    }

    public AreaService getAreaService() {
        return areaService;
    }

    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    public SuburbService getSuburbService() {
        return suburbService;
    }

    public void setSuburbService(SuburbService suburbService) {
        this.suburbService = suburbService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public StageService getStageService() {
        return stageService;
    }

    public void setStageService(StageService stageService) {
        this.stageService = stageService;
    }

    public BuildingService getBuildingService() {
        return buildingService;
    }

    public void setBuildingService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    public FloorplanService getFloorplanService() {
        return floorplanService;
    }

    public void setFloorplanService(FloorplanService floorplanService) {
        this.floorplanService = floorplanService;
    }

}
