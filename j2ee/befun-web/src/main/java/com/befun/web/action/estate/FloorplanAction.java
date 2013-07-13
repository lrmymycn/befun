package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.PaginationBean;
import com.befun.domain.community.Comment;
import com.befun.domain.community.FloorplanComment;
import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Project;
import com.befun.service.IBaseService;
import com.befun.service.estate.ApartmentService;
import com.befun.service.estate.FloorplanCommentService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.estate.ProjectService;
import com.befun.service.query.estate.ApartmentQueryCondition;
import com.befun.service.query.estate.FloorplanCommentQueryCondition;
import com.befun.service.query.estate.FloorplanQueryCondition;
import com.befun.web.action.CRUDAction;
import com.befun.web.view.ApartmentView;
import com.befun.web.view.FloorplanView;
import com.befun.web.view.ProjectView;
import com.befun.web.view.converter.ApartmentConverter;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ProjectConverter;
import com.befun.web.view.converter.ViewConverter;

@Controller("FloorplanAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FloorplanAction extends CRUDAction<Floorplan, FloorplanView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private FloorplanQueryCondition qc = new FloorplanQueryCondition();

    private ApartmentQueryCondition apQC = new ApartmentQueryCondition();

    private PaginationBean<Comment> pgbComment = null;

    private ProjectView projectView = null;

    private ProjectConverter projectConverter = ConverterFactory.getConverter(Project.class);

    private static ApartmentConverter apConverter = ConverterFactory.getConverter(Apartment.class);

    @Resource
    @Qualifier("ProjectService")
    private ProjectService projectService;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService service;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService apartmentService;

    @Resource
    @Qualifier("FloorplanCommentService")
    private FloorplanCommentService floorplanCommentService;

    public String demandRecommended() {
        FloorplanQueryCondition fpQc = new FloorplanQueryCondition();
        fpQc.setRecommended(true);
        fpQc.setBdQC(null);
        this.qc = fpQc;
        return this.demand();
    }

    public String recommend() {
        try {
            this.service.recommend(this.id);
            this.addActionMessage("Recommended!");
        } catch (Exception ex) {
            String errMsg = "Recommend failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String unRecommend() {
        try {
            this.service.unRecommend(this.id);
            this.addActionMessage("UnRecommended!");
        } catch (Exception ex) {
            String errMsg = "UnRecommend failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demandById() {
        if (this.getId() == null) {
            String msg = "Please provide id!";
            this.log.warn(msg);
            this.addActionError(msg);
            return ERROR;
        }
        try {
            // Floorplan obj = this.service.getWithAveragePrice(this.getId());
            Floorplan obj = this.service.get(this.getId());
            if (obj == null) {
                String msg = "Floorplan with id:" + this.getId() + " not found!";
                this.log.warn(msg);
                this.addActionError(msg);
                return ERROR;
            }
            this.view = this.getConverter().convertToView(obj);
            FloorplanViewFilter.filter(this.isAnonymous(), this.view);
            if (!this.isAnonymous()) {
                if (this.apQC == null) {
                    this.apQC = new ApartmentQueryCondition();
                }
                this.apQC.setFloorplanId(this.getId());
                List<Apartment> apartmentObjs = this.apartmentService.query(this.apQC);
                List<ApartmentView> apartments = new ArrayList<ApartmentView>();
                for (Apartment a : apartmentObjs) {
                    ApartmentView av = apConverter.convertToView(a);
                    apartments.add(av);
                }
                this.view.setApartments(apartments);
            }

            Project pro = projectService.get(this.view.getProjectId());
            if (pro == null) {
                String msg = "Project with id:" + this.getId() + " not found!";
                this.log.warn(msg);
                this.addActionError(msg);
                return ERROR;
            }
            this.projectView = projectConverter.convertToView(pro);
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demandWithComments() {
        String rs = this.demandById();
        if (!SUCCESS.equals(rs)) {
            return rs;
        }
        return this.demandFloorplanComment(this.getId());
    }

    private String demandFloorplanComment(Long floorplanId) {
        FloorplanCommentQueryCondition qc = new FloorplanCommentQueryCondition();
        qc.setEnabled(null);
        qc.setFloorplanId(floorplanId);
        try {
            PaginationBean<FloorplanComment> rs = this.floorplanCommentService.query(qc, 1, 10);
            this.pgbComment = new PaginationBean<Comment>();

            BeanUtils.copyProperties(rs, this.pgbComment, new String[] { "models" });
            this.pgbComment.setModels(new ArrayList<Comment>());
            for (FloorplanComment com : rs.getModels()) {
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

    public void setQc(FloorplanQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public FloorplanQueryCondition getQc() {
        return qc;
    }

    public ApartmentQueryCondition getApQC() {
        return apQC;
    }

    public void setApQC(ApartmentQueryCondition apQC) {
        this.apQC = apQC;
    }

    public FloorplanView getView() {
        return this.view;
    }

    public void setView(FloorplanView view) {
        this.view = view;
    }

    public PaginationBean<Comment> getPgbComment() {
        return pgbComment;
    }

    public void setPgbComment(PaginationBean<Comment> pgbComment) {
        this.pgbComment = pgbComment;
    }

    public ProjectView getProjectView() {
        return projectView;
    }

    public void setProjectView(ProjectView projectView) {
        this.projectView = projectView;
    }

    @Override
    public ViewConverter<Floorplan, FloorplanView> getConverter() {
        return ConverterFactory.getConverter(Floorplan.class);
    }

    @Override
    public IBaseService<Floorplan, Long> getService() {
        return service;
    }

}
