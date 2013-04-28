package com.befun.dao;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.QueryCondition;
import com.befun.domain.PaginationBean;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.ModelModification;
import com.befun.domain.estate.Project;

public class TestCommonDao extends DaoTestBase {

    @Resource
    private CommonHibernateDao target;

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
        Long id = target.save(area);
        System.out.println(id);
    }

    @Test
    public void testCount() {
        IQueryCondition queryCondition = new QueryCondition();
        long i = target.count(Area.class, queryCondition);
        System.out.println(i);
    }

    @Test
    public void testQuery() {
        IQueryCondition queryCondition = new QueryCondition();
        PaginationBean<Area> pb = target.query(Area.class, queryCondition, 1, 2);

        assertSame(2, pb.getModels().size());
        assertTrue(pb.getPageNumber() == 1l);
    }

    @Test
    public void testQueryGroup() {
        QueryCondition qc = new QueryCondition();
        List<String> groupProperties = new ArrayList<String>();
        groupProperties.add("suburb");
        qc.setGroupProperties(groupProperties);

        List<Object[]> rs = target.queryGroup(Project.class, qc);
        if (rs == null) {
            fail("Rs should be not null!");
        }
        for (Object[] t : rs) {
            for (Object o : t) {
                System.out.println("o.getClass(): " + o.getClass());
                System.out.println("o:" + o);
            }
        }
    }
}
