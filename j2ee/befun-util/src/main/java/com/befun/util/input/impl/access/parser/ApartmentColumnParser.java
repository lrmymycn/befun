package com.befun.util.input.impl.access.parser;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.ModelModification;
import com.befun.util.input.impl.access.AccessUtil;

public class ApartmentColumnParser implements ColumnParser<Apartment> {

    @Override
    public Apartment parse(Map<String, Object> col) {
        Apartment rs = new Apartment();
        rs.setBid(AccessUtil.getString(col, "id"));
        rs.setCarParkingCount(AccessUtil.getShort(col, "car_parking_count"));
        rs.setColorScheme(AccessUtil.getString(col, "colorscheme"));
        rs.setDescription(AccessUtil.getString(col, "description"));
        rs.setFloorLevel(AccessUtil.getShort(col, "floor"));
        
        String floorplanId = AccessUtil.getString(col, "floorplan_id");
        if (StringUtils.isNotBlank(floorplanId)) {
            Floorplan floorplan = new Floorplan();
            floorplan.setBid(floorplanId);
            rs.setFloorplan(floorplan);
        } else {
            throw new IllegalArgumentException("floorplan_id should be not null for Apartment: " + rs.getBid());
        }
                
        rs.setLotNumber(AccessUtil.getString(col, "lot_number"));
        rs.setPentHouse(AccessUtil.getBool(col, "penthouse"));
        rs.setPrice(AccessUtil.getInteger(col, "price"));
        rs.setSoldOut(AccessUtil.getBool(col, "sold_out"));
        rs.setStorageRoomCount(AccessUtil.getShort(col, "storageroom_count"));
        rs.setUnitEntitlement(AccessUtil.getShort(col, "unit_entitle_ment"));
        rs.setUnitNumber(AccessUtil.getString(col, "unit_number"));

        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }

}
