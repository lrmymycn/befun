package com.befun.service.estate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.AreaPolyline;
import com.befun.service.SpringTestBase;

public class TestAreaService extends SpringTestBase {

    @Resource
    @Qualifier("AreaService")
    private AreaService target;

    @Test
    public void testSaveOrUpdateAndPolylines() {
        Area a = new Area();
        a.setLatitude(1.1);
        a.setLongitude(2.2);
        a.setName("test");
        a.setDescription("desc");
        List<AreaPolyline> polylines = new ArrayList<AreaPolyline>();
        AreaPolyline p1 = new AreaPolyline();
        p1.setLatitude(11.1);
        p1.setLongitude(22.2);
        p1.setSeqNum(0);
        polylines.add(p1);

        AreaPolyline p2 = new AreaPolyline();
        p2.setLatitude(111.1);
        p2.setLongitude(122.2);
        p2.setSeqNum(1);
        polylines.add(p2);

        a.setPolylines(polylines);

        target.saveOrUpdateWithPolylines(a, null);
    }

    @Test
    public void testSaveOrUpdateAndPolylines1() {
        Area a = new Area();
        a.setId(5l);
        a.setLatitude(1.1);
        a.setLongitude(2.2);
        a.setName("test");
        a.setDescription("desc");
        List<AreaPolyline> polylines = new ArrayList<AreaPolyline>();
        AreaPolyline p1 = new AreaPolyline();
        p1.setLatitude(11.1);
        p1.setLongitude(22.2);
        p1.setSeqNum(0);
        polylines.add(p1);

        a.setPolylines(polylines);

        target.saveOrUpdateWithPolylines(a, null);
    }
}
