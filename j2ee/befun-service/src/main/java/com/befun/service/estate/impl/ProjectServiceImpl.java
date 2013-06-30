package com.befun.service.estate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.dao.estate.AreaDao;
import com.befun.dao.estate.SuburbDao;
import com.befun.domain.community.ProjectComment;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.service.estate.FloorplanService;
import com.befun.service.estate.MediaService;
import com.befun.service.estate.ProjectCommentService;
import com.befun.service.estate.ProjectMediaService;
import com.befun.service.estate.ProjectService;
import com.befun.service.estate.StageService;
import com.befun.service.query.estate.EstateQueryCondition;
import com.befun.service.query.estate.MediaQueryCondition;
import com.befun.service.query.estate.ProjectCommentQueryCondition;
import com.befun.service.query.estate.ProjectMediaQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;

@Service("ProjectService")
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl extends BaseEstateServiceImpl<Project, Long> implements ProjectService {

    @Resource
    @Qualifier("AreaDao")
    private AreaDao areaDao;

    @Resource
    @Qualifier("SuburbDao")
    private SuburbDao suburbDao;

    @Resource
    @Qualifier("ProjectMediaService")
    private ProjectMediaService projectMediaService;

    @Resource
    @Qualifier("ProjectCommentService")
    private ProjectCommentService projectCommentService;

    @Resource
    @Qualifier("StageService")
    private StageService stageService;

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService floorplanService;

    @Resource
    @Qualifier("MediaService")
    private MediaService mediaService;

    @Transactional(readOnly = true)
    public Map<Area, Long> queryGroupByArea(ProjectQueryCondition qc) {
        EstateQueryCondition aQc = new EstateQueryCondition();
        List<Area> allAreas = this.areaDao.query(aQc);
        System.out.println(allAreas.size());

        qc.setGroupByArea(true);
        qc.setGroupBySuburb(false);
        List<Object[]> queryRs = this.dao.queryGroup(qc);
        Map<Area, Long> result = new HashMap<Area, Long>();
        for (Area a : allAreas) {
            result.put(a, 0l);
        }

        for (Object[] st : queryRs) {
            result.put((Area) st[0], (Long) st[1]);
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Map<Suburb, Long> queryGroupBySuburb(ProjectQueryCondition qc) {
        EstateQueryCondition sQc = new EstateQueryCondition();
        List<Suburb> allSuburbs = this.suburbDao.query(sQc);

        qc.setGroupByArea(false);
        qc.setGroupBySuburb(true);
        List<Object[]> queryRs = this.dao.queryGroup(qc);
        Map<Suburb, Long> result = new HashMap<Suburb, Long>();

        for (Suburb s : allSuburbs) {
            s.getPolylines().size();
            s.getArea().getPolylines().size();
            result.put(s, 0l);
        }

        for (Object[] st : queryRs) {
            result.put((Suburb) st[0], (Long) st[1]);
        }
        return result;
    }

    @Override
    public Long save(Project model) {
        Assert.notNull(model, "model should be not null!");
        if (StringUtils.isBlank(model.getBid())) {
            model.setBid("pro_" + UUID.randomUUID().toString());
        }
        return super.save(model);
    }

    @Override
    public void deleteDependency(Long id) {
        Assert.notNull(id, "id should be not null!");
        Project project = this.get(id);
        if (project == null) {
            return;
        }
        project.setPicture(null);
        project.setLogo(null);
        
        ProjectCommentQueryCondition pcQC = new ProjectCommentQueryCondition();
        pcQC.setEnabled(null);
        pcQC.setProjectId(id);
        List<ProjectComment> comments = this.projectCommentService.query(pcQC);
        this.projectCommentService.deleteObject(comments);

        ProjectMediaQueryCondition pmQC = new ProjectMediaQueryCondition();
        pmQC.setEnabled(null);
        pmQC.setRemoved(null);
        pcQC.setProjectId(id);
        List<ProjectMedia> projectMedias = this.projectMediaService.query(pmQC);
        this.projectMediaService.deleteObject(projectMedias);
        
        Set<Stage> stages = project.getStages();
        project.setStages(null);
        for (Stage stage : stages) {
            this.stageService.deleteDependency(stage.getId());
        }

        MediaQueryCondition mQC = new MediaQueryCondition();
        mQC.setEnabled(null);
        mQC.setRemoved(null);
        mQC.setProjectId(id);
        List<Media> medias = this.mediaService.query(mQC);
        this.mediaService.deleteObject(medias);

        this.delete(id);
    }

    @Resource
    public void setDao(@Qualifier("ProjectDao") IBaseDao<Project, Long> dao) {
        this.dao = dao;
    }

}
