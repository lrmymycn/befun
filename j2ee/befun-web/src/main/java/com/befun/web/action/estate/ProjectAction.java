package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.dao.common.QueryCondition;
import com.befun.domain.PaginationBean;
import com.befun.domain.community.Comment;
import com.befun.domain.community.ProjectComment;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Suburb;
import com.befun.service.IBaseService;
import com.befun.service.estate.ApartmentService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.estate.ProjectCommentService;
import com.befun.service.estate.ProjectMediaService;
import com.befun.service.estate.ProjectService;
import com.befun.service.query.QCUtils;
import com.befun.service.query.estate.ApartmentQueryCondition;
import com.befun.service.query.estate.BuildingQueryCondition;
import com.befun.service.query.estate.FloorplanQueryCondition;
import com.befun.service.query.estate.ProjectCommentQueryCondition;
import com.befun.service.query.estate.ProjectMediaQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.AreaView;
import com.befun.web.view.FloorplanView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.SuburbView;
import com.befun.web.view.converter.AreaConverter;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.FloorplanConverter;
import com.befun.web.view.converter.ProjectConverter;
import com.befun.web.view.converter.SuburbConverter;
import com.befun.web.view.converter.ViewConverter;

@Controller("ProjectAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectAction extends CRUDAction<Project, ProjectView> {

    private static final long serialVersionUID = 7103590937940363546L;

    private ProjectQueryCondition qc = new ProjectQueryCondition();

    private List<AreaView> aggRs = new ArrayList<AreaView>();

    private ProjectConverter converter = ConverterFactory.getConverter(Project.class);

    private AreaConverter areaConverter = ConverterFactory.getConverter(Area.class);

    private SuburbConverter suburbConverter = ConverterFactory.getConverter(Suburb.class);

    private FloorplanConverter floorplanConverter = ConverterFactory.getConverter(Floorplan.class);

    private PaginationBean<Comment> pgbComment = null;

    @Resource
    @Qualifier("ProjectService")
    private ProjectService service;

    @Resource
    @Qualifier("ProjectMediaService")
    private ProjectMediaService projectMediaService;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService floorplanService;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService apartmentService;

    @Resource
    @Qualifier("ProjectCommentService")
    private ProjectCommentService projectCommentService;

    public String demandAggregated() {
        // query aggregated information
        Map<Suburb, Long> queryRs = service.queryGroupBySuburb(qc);
        Area tmpA = null;
        AreaView tmpAV = null;
        Suburb tmpS = null;
        for (Entry<Suburb, Long> e : queryRs.entrySet()) {
            tmpS = e.getKey();
            tmpA = tmpS.getArea();
            Long count = e.getValue();
            tmpAV = getAreaView(this.aggRs, tmpA.getId());
            if (tmpAV == null) {
                tmpAV = this.areaConverter.convertToView(tmpA);
                this.aggRs.add(tmpAV);
            }
            SuburbView tmpSV = this.suburbConverter.convertToView(tmpS);
            tmpSV.setProjectCounts(count);
            tmpAV.getSuburbs().add(tmpSV);
            tmpAV.setProjectCounts(tmpAV.getProjectCounts() + count);
        }
        // query projects information
        qc.setGroupBySuburb(false);
        qc.setGroupByArea(false);
        qc.getOrderBy().add(Order.desc(QCUtils.generatePropertyName(qc.getSelfAlias(), "rank")));
        PaginationBean<Project> projects = service.query(qc, pn, ps);
        this.pgb = new PaginationBean<ProjectView>();
        this.pgb.setModels(new ArrayList<ProjectView>());
        BeanUtils.copyProperties(projects, this.pgb, new String[] { "models" });
        for (Project obj : projects.getModels()) {
            ProjectView v = this.converter.convertToView(obj);
            this.pgb.getModels().add(v);
        }
        return SUCCESS;
    }

    private AreaView getAreaView(List<AreaView> views, Long id) {
        for (AreaView a : views) {
            if (a.getModel().getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public String demandById() {
        if (this.getId() == null) {
            String msg = "Please provide id!";
            this.log.warn(msg);
            this.addActionError(msg);
            return ERROR;
        }
        try {
            Project obj = service.get(this.id);
            if (obj == null) {
                String msg = "Project with id:" + this.getId() + " not found!";
                this.log.warn(msg);
                this.addActionError(msg);
                return ERROR;
            }
            this.view = converter.convertToView(obj);
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demandDetail() {
        if (this.getId() == null) {
            String msg = "Please provide id!";
            this.log.warn(msg);
            this.addActionError(msg);
            return ERROR;
        }
        try {
            Project obj = service.get(this.id);
            if (obj == null) {
                String msg = "Project with id:" + this.getId() + " not found!";
                this.log.warn(msg);
                this.addActionError(msg);
                return ERROR;
            }
            this.view = converter.convertToView(obj);
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }

        ApartmentQueryCondition apQC = qc.getApQC();
        if (apQC == null) {
            apQC = new ApartmentQueryCondition();
            qc.setApQC(apQC);
        }
        FloorplanQueryCondition fpQC = apQC.getFpQC();
        if (fpQC == null) {
            fpQC = new FloorplanQueryCondition();
            apQC.setFpQC(fpQC);
        }
        BuildingQueryCondition bQC = fpQC.getBdQC();
        if (bQC == null) {
            bQC = new BuildingQueryCondition();
            fpQC.setBdQC(bQC);
        }
        bQC.setProjectId(this.id);
        List<Floorplan> floorplans = this.apartmentService.queryFloorplans(apQC);
        for (Floorplan f : floorplans) {
            FloorplanView v = floorplanConverter.convertToView(f);
            FloorplanViewFilter.filter(this.isAnonymous(), v);
            this.view.getFloorplans().add(v);
        }

        ProjectMediaQueryCondition pmQC = new ProjectMediaQueryCondition();
        pmQC.setProjectId(this.id);
        pmQC.getOrderBy().add(Order.asc(QCUtils.generatePropertyName(pmQC.getSelfAlias(), "seqNum")));
        List<ProjectMedia> projectMedias = this.projectMediaService.query(pmQC);
        List<Media> medias = new ArrayList<Media>();
        for (ProjectMedia pm : projectMedias) {
            medias.add(pm.getMedia());
        }
        this.view.setMedias(medias);
        return SUCCESS;
    }

    public String demandWithComments() {
        String rs = this.demandDetail();
        if (!SUCCESS.equals(rs)) {
            return rs;
        }
        return this.demandProjectComment(this.getId());
    }

    private String demandProjectComment(Long projectId) {
        ProjectCommentQueryCondition qc = new ProjectCommentQueryCondition();
        qc.setEnabled(null);
        qc.setProjectId(projectId);
        try {
            PaginationBean<ProjectComment> rs = this.projectCommentService.query(qc, 1, 10);
            this.pgbComment = new PaginationBean<Comment>();

            BeanUtils.copyProperties(rs, this.pgbComment, new String[] { "models" });
            this.pgbComment.setModels(new ArrayList<Comment>());
            for (ProjectComment com : rs.getModels()) {
                this.pgbComment.getModels().add(com.getComment());
            }
        } catch (Exception ex) {
            String errMsg = "Demand failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public void setQc(ProjectQueryCondition qc) {
        this.qc = qc;
    }

    public List<AreaView> getAggRs() {
        return aggRs;
    }

    public ProjectView getView() {
        return this.view;
    }

    public void setView(ProjectView view) {
        this.view = view;
    }

    @Override
    public QueryCondition getQc() {
        return this.qc;
    }

    public PaginationBean<Comment> getPgbComment() {
        return pgbComment;
    }

    public void setPgbComment(PaginationBean<Comment> pgbComment) {
        this.pgbComment = pgbComment;
    }

    @Override
    public ViewConverter<Project, ProjectView> getConverter() {
        return ConverterFactory.getConverter(Project.class);
    }

    @Override
    public IBaseService<Project, Long> getService() {
        return service;
    }

}
