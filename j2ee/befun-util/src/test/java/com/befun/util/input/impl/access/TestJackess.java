package com.befun.util.input.impl.access;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;

public class TestJackess {

    private AccessConnDesc connDesc;

    @Before
    public void init() {
        String username = null;
        String password = "ywll_677)(*!@#";
        String filePath = "E:\\Personal\\lhl\\input\\App\\project-import.accdb";
        connDesc = new AccessConnDesc(filePath, username, password);
    }

    @Test
    public void testProjectColumnType() {
        Database db = null;
        try {
            db = Database.open(new File(this.connDesc.getFilePath()));
            Table t = db.getTable("project");
            Iterator<Map<String, Object>> it = t.iterator();
            Map<String, Object> col = null;
            while (it.hasNext()) {
                col = it.next();
                AccessUtil.getObject(col, "address");
                AccessUtil.getObject(col, "bbq");
                AccessUtil.getObject(col, "id");
                AccessUtil.getObject(col, "block");
                AccessUtil.getObject(col, "car_wash_bay");
                AccessUtil.getObject(col, "description");
                AccessUtil.getObject(col, "developer");
                AccessUtil.getObject(col, "distancetocity");
                AccessUtil.getObject(col, "features");
                AccessUtil.getObject(col, "finish_date");
                AccessUtil.getObject(col, "finish_schema");
                AccessUtil.getObject(col, "func_room");
                AccessUtil.getObject(col, "gym");
                AccessUtil.getObject(col, "kids_play_ground");
                AccessUtil.getObject(col, "land_scaping");
                AccessUtil.getObject(col, "latitude");
                AccessUtil.getObject(col, "library");
                AccessUtil.getObject(col, "logo_id");
                AccessUtil.getObject(col, "longitude");
                AccessUtil.getObject(col, "music_room");
                AccessUtil.getObject(col, "name1");
                AccessUtil.getObject(col, "others");
                AccessUtil.getObject(col, "picture_id");
                AccessUtil.getObject(col, "play_room");
                AccessUtil.getObject(col, "postcode");
                AccessUtil.getObject(col, "recreation_place");
                AccessUtil.getObject(col, "sauna");
                AccessUtil.getObject(col, "site_url");
                AccessUtil.getObject(col, "sky_garden");
                AccessUtil.getObject(col, "swimming_pool");
                AccessUtil.getObject(col, "tennis_court");
                AccessUtil.getObject(col, "theatre_cinema");
                AccessUtil.getObject(col, "visitor_parking");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccessException("Query on access error!", e);
        } finally {
            this.closeDb(db);
        }
    }

    private void closeDb(Database db) {
        if (db != null) {
            try {
                db.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
