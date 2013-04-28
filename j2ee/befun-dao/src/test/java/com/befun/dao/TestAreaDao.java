package com.befun.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.befun.dao.estate.AreaDao;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.ModelModification;

public class TestAreaDao extends DaoTestBase {

    @Resource
    private AreaDao target;

    @Test
    public void testSave() {
        Area area = new Area();
        area.setBid("bid");
        area.setDescription("description");
        area.setLatitude(1.0);
        area.setLongitude(2.0);
        area.setName("name");
        ModelModification mm = new ModelModification();
        area.setModelModification(mm);
        mm.setRemoved(true);
        mm.setEnabled(true);
        mm.setLastModifiedDate(new Date());
        mm.setCreationDate(new Date());
        target.save(area);
    }
}
