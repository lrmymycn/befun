package com.befun.util.input;

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

public interface ImportDataSource {

    List<Media> listMedias();

    List<Area> listAreas();

    List<Suburb> listSuburbs();

    List<Project> listProjects();

    List<ProjectMedia> listProjectMedias();

    List<Stage> listStages();

    List<Building> listBuildings();

    List<Floorplan> listFloorplans();

    List<Apartment> listApartments();

}
