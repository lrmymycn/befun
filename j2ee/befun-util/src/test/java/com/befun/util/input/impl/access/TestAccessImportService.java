package com.befun.util.input.impl.access;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.util.input.ImportDataSource;
import com.befun.util.input.ImportException;

public class TestAccessImportService extends TransactionTestBase {

    @Resource
    @Qualifier("AccessImportService")
    private AccessImportService target;

    @Test
    public void testImport() {
        ImportDataSource ds = this.getDs1();
        try {
            target.importMedia(ds);
            target.importProject(ds);
            target.importProjectMedia(ds);
            target.importStage(ds);
            target.importBuilding(ds);
            target.importFloorplan(ds);
            target.importApartment(ds);
        } catch (ImportException e) {
            e.printStackTrace();
        }
    }

    private ImportDataSource getDs1() {
        Access2010DataSource ds = new Access2010DataSource();
        AccessDao dao = new AccessDao();
        String username = null;
        String password = "ywll_677)(*!@#";
        String filePath = "E:\\Personal\\lhl\\input\\App\\project-import.accdb";
        AccessConnDesc connDesc = new AccessConnDesc(filePath, username, password);
        dao.setConnDesc(connDesc);
        ds.setDao(dao);
        return ds;
    }
}
