package com.befun.util.input.impl.access.parser;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.befun.domain.estate.Building;
import com.befun.domain.estate.ModelModification;
import com.befun.domain.estate.Stage;
import com.befun.util.input.impl.access.AccessUtil;

public class BuildingColumnParser implements ColumnParser<Building> {

    @Override
    public Building parse(Map<String, Object> col) {
        Building rs = new Building();
        rs.setBid(AccessUtil.getString(col, "id"));
        rs.setBuildingNumber(AccessUtil.getString(col, "building_num"));
        rs.setDescription(AccessUtil.getString(col, "description"));
        rs.setFinishDate(AccessUtil.getDate(col, "finish_date"));
        rs.setFloorCount(AccessUtil.getShort(col, "floor_count"));
        rs.setOrientation(AccessUtil.getShort(col, "orientation"));
        rs.setReadyHouse(AccessUtil.getBool(col, "ready_house"));
        rs.setSold(0);
        rs.setSoldOut(false);
        
        String stageId = AccessUtil.getString(col, "stage_id");
        if (StringUtils.isNotBlank(stageId)) {
            Stage stage = new Stage();
            stage.setBid(stageId);
            rs.setStage(stage);
        } else {
            throw new IllegalArgumentException("stage_id should be not null for Building: " + rs.getBid());
        }
        
        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }

}
