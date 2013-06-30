package com.befun.service.estate.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.service.estate.BuildingService;
import com.befun.service.estate.FloorplanService;

@Service("BuildingService")
@Transactional(rollbackFor = Exception.class)
public class BuildingServiceImpl extends BaseEstateServiceImpl<Building, Long> implements BuildingService {

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService floorplanService;

    @Override
    @Resource
    public void setDao(@Qualifier("BuildingDao") IBaseDao<Building, Long> dao) {
        this.dao = dao;
    }

    @Override
    public void deleteDependency(Long id) {
        Assert.notNull(id, "id should be not null!");
        Building building = this.get(id);
        if (building == null) {
            return;
        }

        Set<Floorplan> floorplans = building.getFloorplans();
        building.setFloorplans(null);
        for (Floorplan floorplan : floorplans) {
            this.floorplanService.deleteDependency(floorplan.getId());
        }
        this.delete(id);
    }
}
