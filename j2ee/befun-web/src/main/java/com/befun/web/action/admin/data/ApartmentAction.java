package com.befun.web.action.admin.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.estate.ApartmentService;
import com.befun.service.query.estate.ApartmentQueryCondition;
import com.befun.service.query.estate.AreaQueryCondition;
import com.befun.service.query.estate.BuildingQueryCondition;
import com.befun.service.query.estate.FloorplanQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.service.query.estate.StageQueryCondition;
import com.befun.service.query.estate.SuburbQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.ApartmentView;
import com.befun.web.view.AreaView;
import com.befun.web.view.BuildingView;
import com.befun.web.view.FloorplanView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.StageView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminApartmentAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApartmentAction<T extends Apartment, V extends ApartmentView> extends AdminAction<Apartment, ApartmentView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private ApartmentQueryCondition qc = new ApartmentQueryCondition();

    private List<AreaView> qcAreas = new ArrayList<AreaView>();

    private List<SuburbView> qcSuburbs = new ArrayList<SuburbView>();

    private List<ProjectView> qcProjects = new ArrayList<ProjectView>();

    private List<StageView> qcStages = new ArrayList<StageView>();

    private List<BuildingView> qcBuildings = new ArrayList<BuildingView>();

    private List<FloorplanView> qcFloorplans = new ArrayList<FloorplanView>();

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService service;
    
    public ApartmentAction(){
        this.view = new ApartmentView();
    }

    protected void prepareQueryList() {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        // queryCondition.setEnabled(null);
        List<Area> areas = this.areaService.query(queryCondition);
        AreaView av = null;
        for (Area a : areas) {
            av = areaConverter.convertToView(a);
            qcAreas.add(av);
        }
        if (this.qc != null && this.qc.getFpQC().getBdQC() != null && this.qc.getFpQC().getBdQC().getProQC() != null && this.qc.getFpQC().getBdQC().getProQC().getSuburbQC() != null
            && this.qc.getFpQC().getBdQC().getProQC().getSuburbQC().getAreaId() != null) {
            SuburbQueryCondition sQC = this.qc.getFpQC().getBdQC().getProQC().getSuburbQC();
            // sQC.setEnabled(null);
            List<Suburb> suburbs = this.suburbService.query(sQC);
            SuburbView sv = null;
            for (Suburb s : suburbs) {
                sv = suburbConverter.convertToView(s);
                qcSuburbs.add(sv);
            }
        }
        if (this.qc != null && this.qc.getFpQC().getBdQC() != null && this.qc.getFpQC().getBdQC().getProQC() != null && this.qc.getFpQC().getBdQC().getProQC().getSuburbId() != null) {
            ProjectQueryCondition pQC = this.qc.getFpQC().getBdQC().getProQC();
            // sQC.setEnabled(null);
            List<Project> projects = this.projectService.query(pQC);
            ProjectView sv = null;
            for (Project s : projects) {
                sv = projectConverter.convertToView(s);
                qcProjects.add(sv);
            }
        }

        if (this.qc != null && this.qc.getFpQC().getBdQC() != null && this.qc.getFpQC().getBdQC().getProjectId() != null) {
            StageQueryCondition stQC = new StageQueryCondition();
            stQC.setProjectId(this.qc.getFpQC().getBdQC().getProjectId());
            // sQC.setEnabled(null);
            List<Stage> stages = this.stageService.query(stQC);
            StageView sv = null;
            for (Stage s : stages) {
                sv = stageConverter.convertToView(s);
                qcStages.add(sv);
            }
        }
        if (this.qc != null && this.qc.getFpQC().getBdQC() != null && this.qc.getFpQC().getBdQC().getStageId() != null) {
            BuildingQueryCondition bQC = this.qc.getFpQC().getBdQC();
            // sQC.setEnabled(null);
            List<Building> buildings = this.buildingService.query(bQC);
            BuildingView sv = null;
            for (Building s : buildings) {
                sv = buildingConverter.convertToView(s);
                qcBuildings.add(sv);
            }
        }
        if (this.qc != null && this.qc.getFpQC() != null && this.qc.getFpQC().getBuildingId() != null) {
            FloorplanQueryCondition fpQC = this.qc.getFpQC();
            // sQC.setEnabled(null);
            List<Floorplan> floorplans = this.floorplanService.query(fpQC);
            FloorplanView sv = null;
            for (Floorplan s : floorplans) {
                sv = floorplanConverter.convertToView(s);
                qcFloorplans.add(sv);
            }
        }
    }

    /*
     * private void jmesa() {
     * HttpServletRequest request = this.getRequest();
     * TableModel tableModel = new TableModel("views", request);
     * 
     * tableModel.setItems(new PageItems() {
     * 
     * public int getTotalRows(Limit limit) {
     * return (int)pgb.getTotalCount();
     * }
     * 
     * public Collection<?> getItems(Limit limit) {
     * int start = limit.getRowSelect().getRowStart();
     * int end = limit.getRowSelect().getRowEnd();
     * FilterSet fs = limit.getFilterSet();
     * for (Filter f : fs.getFilters()) {
     * // 如果需要条件过滤的话可以这样去的过滤条件
     * System.out.println(f.getProperty() + "=" + f.getValue());
     * }
     * 
     * return pgb.getModels();
     * }
     * 
     * });
     * tableModel.setTable(getTable());
     * String html = tableModel.render();
     * request.setAttribute("dynaTable", html);
     * }
     * 
     * private HtmlTable getTable() {
     * HtmlTable htmlTable = new HtmlTable().caption("Apartment List").width("600px");
     * 
     * HtmlRow htmlRow = new HtmlRow();
     * htmlTable.setRow(htmlRow);
     * 
     * HtmlColumn id = new HtmlColumn("id");
     * htmlRow.addColumn(id);
     * 
     * HtmlColumn name = new HtmlColumn("description");
     * htmlRow.addColumn(name);
     * 
     * HtmlColumn password = new HtmlColumn("lotNumber");
     * htmlRow.addColumn(password);
     * 
     * HtmlColumn sex = new HtmlColumn("price");
     * htmlRow.addColumn(sex);
     * 
     * HtmlColumn soldOut = new HtmlColumn("soldOut");
     * htmlRow.addColumn(soldOut);
     * 
     * HtmlColumn enabled = new HtmlColumn("enabled");
     * htmlRow.addColumn(enabled);
     * 
     * HtmlColumn delete = new HtmlColumn("Remove");
     * delete.setCellEditor(new CellEditor() {
     * 
     * public Object getValue(Object item, String property, int rowcount) {
     * ApartmentView v = (ApartmentView) item;
     * HtmlBuilder builder = new HtmlBuilder();
     * String js = "javascript:void(0);" + v.getFloorplanId();
     * js = ApartmentAction.this.getRequest().getContextPath() + "/admin/data/removeapartment.action";
     * builder.a().href(js).close();
     * builder.append("删除");
     * builder.aEnd();
     * return builder.toString();
     * }
     * });
     * htmlRow.addColumn(delete);
     * htmlRow.setUniqueProperty("id");
     * return htmlTable;
     * }
     */

    public void setQc(ApartmentQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public ApartmentQueryCondition getQc() {
        return qc;
    }

    public ApartmentView getView() {
        return this.view;
    }

    public void setView(ApartmentView view) {
        this.view = view;
    }

    public List<AreaView> getQcAreas() {
        return qcAreas;
    }

    public List<SuburbView> getQcSuburbs() {
        return qcSuburbs;
    }

    public List<ProjectView> getQcProjects() {
        return qcProjects;
    }

    public List<StageView> getQcStages() {
        return qcStages;
    }

    public List<BuildingView> getQcBuildings() {
        return qcBuildings;
    }

    public List<FloorplanView> getQcFloorplans() {
        return qcFloorplans;
    }

    @Override
    public ViewConverter<Apartment, ApartmentView> getConverter() {
        return ConverterFactory.getConverter(Apartment.class);
    }

    @Override
    public IBaseService<Apartment, Long> getService() {
        return service;
    }

}
