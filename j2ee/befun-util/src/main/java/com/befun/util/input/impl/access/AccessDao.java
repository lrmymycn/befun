package com.befun.util.input.impl.access;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.befun.util.input.impl.access.parser.ColumnParser;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;

public class AccessDao {

    private AccessConnDesc connDesc;

    public AccessDao() {
        super();
    }

    public <T extends Object> List<T> query(String tableName, ColumnParser<T> parser) throws AccessException {
        Database db = null;
        try {
            if (connDesc.getFile() != null) {
                db = Database.open(this.connDesc.getFile());
            } else {
                db = Database.open(new File(this.connDesc.getFilePath()));
            }
            Table t = db.getTable(tableName);
            Iterator<Map<String, Object>> it = t.iterator();
            List<T> rs = new ArrayList<T>();
            Map<String, Object> tmpCol = null;
            while (it.hasNext()) {
                tmpCol = it.next();
                rs.add(parser.parse(tmpCol));
            }
            return rs;
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccessException("Query on access error!", e);
        } finally {
            this.closeDb(db);
        }
    }

    public boolean execute(String sql) throws AccessException {
        return false;
    }

    private void closeDb(Database db) {
        if (db != null) {
            try {
                db.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public AccessConnDesc getConnDesc() {
        return connDesc;
    }

    public void setConnDesc(AccessConnDesc connDesc) {
        this.connDesc = connDesc;
    }

}
