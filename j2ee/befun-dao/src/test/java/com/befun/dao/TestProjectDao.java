package com.befun.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.dao.common.QueryCondition;
import com.befun.dao.estate.ProjectDao;

public class TestProjectDao extends DaoTestBase {

    @Resource
    @Qualifier("ProjectDao")
    private ProjectDao target;

    @Test
    public void testQueryGroup() {
        QueryCondition qc = new QueryCondition();
        List<String> groupProperties = new ArrayList<String>();
        groupProperties.add("suburb");
        qc.setGroupProperties(groupProperties);

        List<Object[]> rs = target.queryGroup(qc);
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
