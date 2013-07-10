package com.befun.util.input.impl.access;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Stage;
import com.befun.service.ICommonService;
import com.befun.service.estate.ProjectMediaService;
import com.befun.util.input.ImportDataSource;
import com.befun.util.input.ImportException;
import com.befun.util.input.ImportService;
import com.befun.util.input.impl.MergeService;

@Component("AccessImportService")
public class AccessImportService implements ImportService {

    @Resource
    @Qualifier("CommonService")
    private ICommonService dbService;

    @Resource
    @Qualifier("ImportMergeService")
    private MergeService mergeService;
    
    @Resource
    @Qualifier("ProjectMediaService")
    private ProjectMediaService projectMediaService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void importData(ImportDataSource ds) throws ImportException {
        this.importMedia(ds);
        this.importProject(ds);
        this.importProjectMedia(ds);
        this.updateMediaProjectProperty(ds);
        this.importStage(ds);
        this.importBuilding(ds);
        this.importFloorplan(ds);
        this.importApartment(ds);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importMedia(ImportDataSource ds) throws ImportException {
        List<Media> list = ds.listMedias();
        for (Media o : list) {
            Media merged = mergeService.mergeMedia(o);
            dbService.saveOrUpdate(merged);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importProject(ImportDataSource ds) throws ImportException {
        List<Project> list = ds.listProjects();
        for (Project o : list) {
            Project merged = mergeService.mergeProject(o);
            dbService.saveOrUpdate(merged);
            if (merged.getId() != null) {
                projectMediaService.removeMediasOfProject(merged.getId());
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importProjectMedia(ImportDataSource ds) throws ImportException {
        List<ProjectMedia> list = ds.listProjectMedias();
        for (ProjectMedia o : list) {
            ProjectMedia merged = mergeService.mergeProjectMedia(o);
            if (merged == null) {
                continue;
            }
            dbService.saveOrUpdate(merged);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMediaProjectProperty(ImportDataSource ds) throws ImportException {
        List<Media> list = ds.listMedias();
        for (Media m : list) {
            if (m.getProjectBid() != null) {
                Project tmpPro = dbService.getByBid(Project.class, m.getProjectBid());
                Media exist = mergeService.getMediaByBid(m.getBid());
                if (exist != null) {
                    exist.setProjectId(tmpPro.getId());
                    dbService.saveOrUpdate(exist);
                }
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importStage(ImportDataSource ds) throws ImportException {
        List<Stage> list = ds.listStages();
        for (Stage o : list) {
            Stage merged = mergeService.mergeStage(o);
            if (merged == null) {
                continue;
            }
            dbService.saveOrUpdate(merged);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importBuilding(ImportDataSource ds) throws ImportException {
        List<Building> list = ds.listBuildings();
        for (Building o : list) {
            Building merged = mergeService.mergeBuilding(o);
            if (merged == null) {
                continue;
            }
            dbService.saveOrUpdate(merged);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importFloorplan(ImportDataSource ds) throws ImportException {
        List<Floorplan> list = ds.listFloorplans();
        for (Floorplan o : list) {
            Floorplan merged = mergeService.mergeFloorplan(o);
            dbService.saveOrUpdate(merged);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void importApartment(ImportDataSource ds) throws ImportException {
        List<Apartment> list = ds.listApartments();
        for (Apartment o : list) {
            Apartment merged = mergeService.mergeApartment(o);
            if (merged == null) {
                continue;
            }
            dbService.saveOrUpdate(merged);
        }
    }

}
