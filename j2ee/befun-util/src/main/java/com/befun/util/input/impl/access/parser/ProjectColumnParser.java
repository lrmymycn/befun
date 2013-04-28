package com.befun.util.input.impl.access.parser;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.befun.domain.estate.Media;
import com.befun.domain.estate.ModelModification;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.util.input.impl.access.AccessUtil;

public class ProjectColumnParser implements ColumnParser<Project> {

    @Override
    public Project parse(Map<String, Object> col) {
        Project rs = new Project();
        rs.setAddress(AccessUtil.getString(col,"address"));
        rs.setBbq(AccessUtil.getBool(col, "bbq"));
        rs.setBid(AccessUtil.getString(col, "id"));
        rs.setBlock(AccessUtil.getString(col, "block"));
        rs.setCarWashBay(AccessUtil.getBool(col, "car_wash_bay"));
        rs.setDescription(AccessUtil.getString(col, "description"));
        rs.setDeveloper(AccessUtil.getString(col, "developer"));
        rs.setDistanceToCity(AccessUtil.getDouble(col, "distancetocity"));
        rs.setFeatures(AccessUtil.getString(col, "features"));
        rs.setFinishDate(AccessUtil.getDate(col, "finish_date"));
        rs.setFinishSchema(AccessUtil.getString(col, "finish_schema"));
        rs.setFuncRoom(AccessUtil.getBool(col, "func_room"));
        rs.setGym(AccessUtil.getBool(col, "gym"));
        rs.setKidsPlayGround(AccessUtil.getBool(col, "kids_play_ground"));
        rs.setLandScaping(AccessUtil.getBool(col, "land_scaping"));
        rs.setLatitude(AccessUtil.getDouble(col, "latitude"));
        rs.setLibrary(AccessUtil.getBool(col, "library"));
        //logo_id
        String logoId = AccessUtil.getString(col, "logo_id");
        if(StringUtils.isNotBlank(logoId)){
            Media logo = new Media();
            logo.setBid(logoId);
            rs.setLogo(logo);   
        }
        
        rs.setLongitude(AccessUtil.getDouble(col, "longitude"));
        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        rs.setMusicRoom(AccessUtil.getBool(col, "music_room"));
        rs.setName(AccessUtil.getString(col, "name1"));
        rs.setOthers(AccessUtil.getBool(col, "others"));
        // picture_id
        String pictureId = AccessUtil.getString(col, "picture_id");
        if(StringUtils.isNotBlank(pictureId)){
            Media picture = new Media();
            picture.setBid(pictureId);
            rs.setPicture(picture);   
        }
        
        rs.setPlayRoom(AccessUtil.getBool(col, "play_room"));
        rs.setPostcode(AccessUtil.getString(col, "postcode"));
        rs.setRecreationPlace(AccessUtil.getBool(col, "recreation_place"));
        rs.setSauna(AccessUtil.getBool(col, "sauna"));
        rs.setSiteUrl(AccessUtil.getString(col, "site_url"));
        rs.setSkyGarden(AccessUtil.getBool(col, "sky_garden"));
        rs.setSold(0);
        rs.setSoldOut(false);
        rs.setSwimmingPool(AccessUtil.getBool(col, "swimming_pool"));
        rs.setTennisCourt(AccessUtil.getBool(col, "tennis_court"));
        rs.setTheatreCinema(AccessUtil.getBool(col, "theatre_cinema"));
        rs.setVisitorParking(AccessUtil.getBool(col, "visitor_parking"));
        
        //test suburb
        Suburb suburb = new Suburb();
        suburb.setId(-1l);
        rs.setSuburb(suburb);
        return rs;
    }

}
