package com.befun.util.input.impl.access.parser;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.befun.domain.estate.Building;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.FloorplanType;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.ModelModification;
import com.befun.util.input.impl.access.AccessUtil;

public class FloorplanColumnParser implements ColumnParser<Floorplan> {
    
    private Log log = LogFactory.getLog(this.getClass());

    @Override
    public Floorplan parse(Map<String, Object> col) {
        Floorplan rs = new Floorplan();
        rs.setBid(AccessUtil.getString(col, "id"));
        rs.setBathroomCount(AccessUtil.getShort(col, "bathroom_count"));
        rs.setBedRoomCount(AccessUtil.getShort(col, "bedroom_count"));

        String buildingId = AccessUtil.getString(col, "building_id");
        if (StringUtils.isNotBlank(buildingId)) {
            Building building = new Building();
            building.setBid(buildingId);
            rs.setBuilding(building);
        } else {
            throw new IllegalArgumentException("building_id should be not null for Floorplan: " + rs.getBid());
        }

        rs.setCourtyardCount(AccessUtil.getShort(col, "courtyard_count"));
        rs.setDescription(AccessUtil.getString(col, "description"));
        rs.setEnclosedBaclonyCount(AccessUtil.getShort(col, "enclosed_baclony_count"));
        rs.setExternalSize(AccessUtil.getDouble(col, "external_size"));
        rs.setInternalSize(AccessUtil.getDouble(col, "internal_size"));
        rs.setLandSize(AccessUtil.getDouble(col, "land_size"));
        rs.setOpenBaclonyCount(AccessUtil.getShort(col, "open_baclony_count"));
        Short orientation = AccessUtil.getShort(col, "orientation");
        rs.setOrientationEast(ParseUtils.getEast(orientation));
        rs.setOrientationSouth(ParseUtils.getSouth(orientation));
        rs.setOrientationWest(ParseUtils.getWest(orientation));
        rs.setOrientationNorth(ParseUtils.getNorth(orientation));

        String publicPictureId = AccessUtil.getString(col, "picture_id");
        if (StringUtils.isNotBlank(publicPictureId)) {
            Media publicPicture = new Media();
            publicPicture.setBid(publicPictureId);
            rs.setPublicPicture(publicPicture);
        } else {
            this.log.warn("picture_id is null!");
//            throw new IllegalArgumentException("picture_id should be not null for Floorplan: " + rs.getBid());
        }

        String salePictureId = AccessUtil.getString(col, "sale_picture_id");
        if (StringUtils.isNotBlank(salePictureId)) {
            Media salePicture = new Media();
            salePicture.setBid(salePictureId);
            rs.setSalePicture(salePicture);
        } else {
            throw new IllegalArgumentException("sale_picture_id should be not null for Floorplan: " + rs.getBid());
        }

        rs.setSold(0);
        rs.setSoldOut(false);
        rs.setSplit(AccessUtil.getBool(col, "is_split"));
        rs.setStudio(AccessUtil.getBool(col, "is_studio"));
        rs.setStudyroomCount(AccessUtil.getShort(col, "studyroom_count"));
        rs.setTotalSize(AccessUtil.getDouble(col, "total_size"));
        Byte v = AccessUtil.getByte(col, "type");
        FloorplanType type = FloorplanType.APARTMENT;
        if (v != null) {
            try {
                type = FloorplanType.getValue(v - 1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        rs.setType(type);

        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }

}
