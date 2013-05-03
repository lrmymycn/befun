package com.befun.service.estate;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.estate.Floorplan;
import com.befun.service.SpringTestBase;

public class TestFloorplanService extends SpringTestBase {

    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService target;
    
    @Test
    public void testGetWithAveragePrice(){
        Floorplan f = target.getWithAveragePrice(2l);
        System.out.println(f);
    }
}
