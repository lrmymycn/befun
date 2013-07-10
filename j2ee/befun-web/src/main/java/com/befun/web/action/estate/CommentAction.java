package com.befun.web.action.estate;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.MyBeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import com.befun.domain.PaginationBean;
import com.befun.domain.community.Comment;
import com.befun.domain.community.FloorplanComment;
import com.befun.domain.community.ProjectComment;
import com.befun.domain.profile.RoleCode;
import com.befun.service.estate.CommentService;
import com.befun.service.estate.FloorplanCommentService;
import com.befun.service.estate.ProjectCommentService;
import com.befun.service.query.estate.FloorplanCommentQueryCondition;
import com.befun.service.query.estate.ProjectCommentQueryCondition;
import com.befun.web.action.BaseAction;

@Controller("CommentAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CommentAction extends BaseAction {

    private static final String[] INCLUDED_PROPERTIES_COMMENT = new String[] { "title", "content" };

    private static final long serialVersionUID = 1423434908904040130L;

    private Long id;

    private Long pn = 1l;

    private Integer ps = 10;

    private PaginationBean<Comment> pgb = null;

    private Long projectId;

    private Long floorplanId;

    private Comment model = null;

    @Resource
    @Qualifier("CommentService")
    private CommentService commentService;

    @Resource
    @Qualifier("ProjectCommentService")
    private ProjectCommentService projectCommentService;

    @Resource
    @Qualifier("FloorplanCommentService")
    private FloorplanCommentService floorplanCommentService;

    public String create() {
        Assert.notNull(this.model);
        Assert.state(this.projectId != null || this.floorplanId != null, "Please provide projectId or floorplanId");
        this.model.setProfile(this.getCurrentProfile());
        this.model.setCreationDate(new Date());

        if (this.projectId != null) {
            return this.createProjectComment(this.projectId, this.model);
        } else if (this.floorplanId != null) {
            return this.createFloorplanComment(this.floorplanId, this.model);
        }

        return ERROR;
    }

    private String createProjectComment(Long projectId, Comment comment) {
        try {
            ProjectComment projectComment = new ProjectComment();
            projectComment.setProjectId(projectId);
            projectComment.setComment(comment);
            this.projectCommentService.save(projectComment);
            this.addActionMessage("Create project comment successfully! ID:" + comment.getId());
        } catch (Exception ex) {
            String errMsg = "Create project comment failure! Object:" + comment;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    private String createFloorplanComment(Long floorplanId, Comment comment) {
        try {
            FloorplanComment floorplanComment = new FloorplanComment();
            floorplanComment.setFloorplanId(floorplanId);
            floorplanComment.setComment(comment);
            this.floorplanCommentService.save(floorplanComment);
            this.addActionMessage("Create floorplan comment successfully! ID:" + comment.getId());
        } catch (Exception ex) {
            String errMsg = "Create floorplan comment failure! Object:" + comment;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String update() {
        Assert.notNull(this.model);
        this.getCurrentProfile();
        Comment exist = this.commentService.get(this.model.getId());
        if (exist == null) {
            String errMsg = "Comment with id:" + this.model.getId() + " not found!";
            this.log.error(errMsg);
            this.addActionError(errMsg);
            return ERROR;
        }
        if (!this.containsAnyRoles(RoleCode.SUPER) && !exist.getProfile().getId().equals(this.getCurrentProfile().getId())) {
            String errMsg = "You are not the author of the comment!";
            this.log.error(errMsg);
            this.addActionError(errMsg);
            return ERROR;
        }
        MyBeanUtils.copyPropertiesInclude(this.model, exist, INCLUDED_PROPERTIES_COMMENT);
        try {
            this.commentService.update(exist);
            this.addActionMessage("Update successfully!");
        } catch (Exception ex) {
            String errMsg = "Update failure! Object:" + exist;
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demand() {
        Assert.state(this.projectId != null || this.floorplanId != null, "Please provide projectId or floorplanId");

        if (this.projectId != null) {
            return this.demandProjectComment(this.projectId);
        } else if (this.floorplanId != null) {
            return this.demandFloorplanComment(this.floorplanId);
        }
        return ERROR;
    }

    private String demandProjectComment(Long projectId) {
        ProjectCommentQueryCondition qc = new ProjectCommentQueryCondition();
        qc.setEnabled(null);
        qc.setProjectId(projectId);
        try {
            PaginationBean<ProjectComment> rs = this.projectCommentService.query(qc, pn, ps);
            this.pgb = new PaginationBean<Comment>();

            BeanUtils.copyProperties(rs, this.pgb, new String[] { "models" });
            this.pgb.setModels(new ArrayList<Comment>());
            for (ProjectComment com : rs.getModels()) {
                this.pgb.getModels().add(com.getComment());
            }
        } catch (Exception ex) {
            String errMsg = "Demand failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    private String demandFloorplanComment(Long floorplanId) {
        FloorplanCommentQueryCondition qc = new FloorplanCommentQueryCondition();
        qc.setEnabled(null);
        qc.setFloorplanId(floorplanId);
        try {
            PaginationBean<FloorplanComment> rs = this.floorplanCommentService.query(qc, pn, ps);
            this.pgb = new PaginationBean<Comment>();

            BeanUtils.copyProperties(rs, this.pgb, new String[] { "models" });
            this.pgb.setModels(new ArrayList<Comment>());
            for (FloorplanComment com : rs.getModels()) {
                this.pgb.getModels().add(com.getComment());
            }
        } catch (Exception ex) {
            String errMsg = "Demand failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String demandById() {
        try {
            model = this.commentService.get(this.getId());
        } catch (Exception ex) {
            String errMsg = "Query failure!";
            this.log.warn(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPn() {
        return pn;
    }

    public void setPn(Long pn) {
        this.pn = pn;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public PaginationBean<Comment> getPgb() {
        return pgb;
    }

    public void setPgb(PaginationBean<Comment> pgb) {
        this.pgb = pgb;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public Comment getModel() {
        return model;
    }

    public void setModel(Comment model) {
        this.model = model;
    }

}
