package com.befun.service.estate.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Building;
import com.befun.domain.estate.Stage;
import com.befun.service.estate.BuildingService;
import com.befun.service.estate.StageService;

@Service("StageService")
@Transactional(rollbackFor = Exception.class)
public class StageServiceImpl extends BaseEstateServiceImpl<Stage, Long> implements StageService {

    @Resource
    @Qualifier("BuildingService")
    private BuildingService buildingService;

    @Override
    @Resource
    public void setDao(@Qualifier("StageDao") IBaseDao<Stage, Long> dao) {
        this.dao = dao;
    }

    @Override
    public void deleteDependency(Long id) {
        Assert.notNull(id, "id should be not null!");
        Stage stage = this.get(id);
        if (stage == null) {
            return;
        }

        Set<Building> buildings = stage.getBuildings();

        stage.setBuildings(null);
        
        for (Building building : buildings) {
            this.buildingService.deleteDependency(building.getId());
        }
        this.delete(id);
    }
}
