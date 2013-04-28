package com.befun.service.profile;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.estate.Project;
import com.befun.service.ICommonService;
import com.befun.service.SpringTestBase;
import com.befun.service.query.ApartmentQueryCondition;
import com.befun.service.query.FloorplanQueryCondition;
import com.befun.service.query.ProjectQueryCondition;
import com.befun.service.query.SuburbQueryCondition;

public class TestProjectService extends SpringTestBase {

    @Resource
    @Qualifier("CommonService")
    private ICommonService target;

    @Test
    public void testQuery() {
        ProjectQueryCondition pqc = new ProjectQueryCondition();
        Long suburbId = 100l;
        pqc.setSuburbId(suburbId);

        target.query(Project.class, pqc);
    }
    
    @Test
    public void testQuery_1() {
        ProjectQueryCondition pqc = new ProjectQueryCondition();
        pqc.setEnabled(null);
        pqc.setDistanceToCity(101.1);
        
        SuburbQueryCondition suburbQC = new SuburbQueryCondition();
        pqc.setSuburbQC(suburbQC);
        
        ApartmentQueryCondition apartmentQC = new ApartmentQueryCondition();
        pqc.setApQC(apartmentQC);
        
        FloorplanQueryCondition floorplanQC = new FloorplanQueryCondition();
        apartmentQC.setFpQC(floorplanQC);
        
        suburbQC.setEnabled(null);
//        suburbQC.setChineseCommunity(true);
//        suburbQC.setKey("suburb_key");
//        suburbQC.setShoppingCenter(false);

        
        apartmentQC.setEnabled(null);
        apartmentQC.setPentHouse(true);
        
        floorplanQC.setEnabled(null);
//        floorplanQC.setFloorplanType(FloorplanType.HOUSE);
        floorplanQC.setMaxBathRoomCount(Short.valueOf("2"));
        
        
        List<Project> rs = target.query(Project.class, pqc);
        System.out.println(rs.size());
    }
}
