package com.befun.service.estate;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.estate.Apartment;
import com.befun.service.SpringTestBase;
import com.befun.service.query.ApartmentQueryCondition;

public class TestApartmentService extends SpringTestBase {

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService target;

    @Test
    public void testModelModification() {
        Apartment rs = target.get(1096l);
        System.out.println(rs);
    }
    
    @Test
    public void testQueryDisabled() {
        ApartmentQueryCondition qc = new ApartmentQueryCondition();
        qc.setEnabled(false);
        List<Apartment> rs = target.query(qc);
        assertSame(1, rs.size());
    }

    @Test
    public void testQueryEnabled() {
        ApartmentQueryCondition qc = new ApartmentQueryCondition();
        qc.setEnabled(false);
        qc.setEnabled(true);
        List<Apartment> rs = target.query(qc);
        assertTrue(0 < rs.size());
    }

    @Test
    public void testQueryIgnoreEnabled() {
        ApartmentQueryCondition qc = new ApartmentQueryCondition();
        qc.setEnabled(null);
        List<Apartment> rs = target.query(qc);
        assertTrue(0 < rs.size());
    }
}
