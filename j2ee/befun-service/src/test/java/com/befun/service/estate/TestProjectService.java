package com.befun.service.estate;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.service.SpringTestBase;
import com.befun.service.query.ProjectQueryCondition;

public class TestProjectService extends SpringTestBase {

    @Resource
    @Qualifier("ProjectService")
    private ProjectService target;

    @Test
    public void testGroupByArea() {
        ProjectQueryCondition qc = new ProjectQueryCondition();
        Map<Area, Long> rs = target.queryGroupByArea(qc);
        assertTrue(12 == rs.size());
        for (Entry<Area, Long> e : rs.entrySet()) {
            assertTrue(0 == e.getValue());
        }
    }
    
    @Test
    public void testGroupBySuburb() {
        ProjectQueryCondition qc = new ProjectQueryCondition();
        Map<Suburb, Long> rs = target.queryGroupBySuburb(qc);
        assertTrue(9 == rs.size());
        for (Entry<Suburb, Long> e : rs.entrySet()) {
            assertTrue(0 == e.getValue());
        }
    }

    @Test
    public void testQueryDisabled() {
        ProjectQueryCondition qc = new ProjectQueryCondition();
        qc.setEnabled(false);
        List<Project> rs = target.query(qc);
        assertTrue(1 == rs.size());
    }

    @Test
    public void testQueryEnabled() {
        ProjectQueryCondition qc = new ProjectQueryCondition();
        qc.setEnabled(true);
        List<Project> rs = target.query(qc);
        assertTrue(0 == rs.size());
    }

    @Test
    public void testQueryIgnoreEnabled() {
        ProjectQueryCondition qc = new ProjectQueryCondition();
        qc.setEnabled(null);
        List<Project> rs = target.query(qc);
        assertTrue(1 == rs.size());
    }
}
