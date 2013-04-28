package com.befun.util.input.impl.access;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.befun.domain.estate.Project;
import com.befun.util.input.impl.access.parser.ProjectColumnParser;

public class TestAccessDao {

    private AccessDao target;

    @Before
    public void init() {
        String username = null;
        String password = "ywll_677)(*!@#";
        String filePath = "E:\\Personal\\lhl\\input\\App\\project-test.mdb";
        AccessConnDesc connDesc = new AccessConnDesc(filePath, username, password);
        target = new AccessDao();
        target.setConnDesc(connDesc);
    }

    @Test
    public void testQueryProjects() {
        List<Project> projects = target.query("project", new ProjectColumnParser());
        assertTrue(projects.size() == 1);
        System.out.println(projects.get(0).getBid());
    }

}
