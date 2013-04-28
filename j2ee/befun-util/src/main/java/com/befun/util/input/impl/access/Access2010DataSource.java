package com.befun.util.input.impl.access;

import java.util.List;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.domain.estate.Stage;
import com.befun.domain.estate.Suburb;
import com.befun.util.input.ImportDataSource;
import com.befun.util.input.impl.access.parser.ApartmentColumnParser;
import com.befun.util.input.impl.access.parser.BuildingColumnParser;
import com.befun.util.input.impl.access.parser.FloorplanColumnParser;
import com.befun.util.input.impl.access.parser.MediaColumnParser;
import com.befun.util.input.impl.access.parser.ProjectColumnParser;
import com.befun.util.input.impl.access.parser.ProjectMediaColumnParser;
import com.befun.util.input.impl.access.parser.StageColumnParser;

public class Access2010DataSource implements ImportDataSource {

    private AccessDao dao;

    @Override
    public List<Media> listMedias() {
        return dao.query("media", new MediaColumnParser());
    }

    @Override
    public List<Area> listAreas() {
        return null;
    }

    @Override
    public List<Suburb> listSuburbs() {
        return null;
    }

    @Override
    public List<Project> listProjects() {
        return dao.query("project", new ProjectColumnParser());
    }

    @Override
    public List<ProjectMedia> listProjectMedias() {
        return dao.query("project_media", new ProjectMediaColumnParser());
    }

    @Override
    public List<Stage> listStages() {
        return dao.query("stage", new StageColumnParser());
    }

    @Override
    public List<Building> listBuildings() {
        return dao.query("building", new BuildingColumnParser());
    }

    @Override
    public List<Floorplan> listFloorplans() {
        return dao.query("floorplan", new FloorplanColumnParser());
    }

    @Override
    public List<Apartment> listApartments() {
        return dao.query("apartment", new ApartmentColumnParser());
    }

    public AccessDao getDao() {
        return dao;
    }

    public void setDao(AccessDao dao) {
        this.dao = dao;
    }

}
