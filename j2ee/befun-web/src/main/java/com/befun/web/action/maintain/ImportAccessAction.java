package com.befun.web.action.maintain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.util.input.ImportDataSource;
import com.befun.util.input.ImportService;
import com.befun.util.input.impl.access.Access2010DataSource;
import com.befun.util.input.impl.access.AccessConnDesc;
import com.befun.util.input.impl.access.AccessDao;
import com.befun.web.action.FileUploadAction;

@Controller("ImportAccessAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ImportAccessAction extends FileUploadAction {

    private static final long serialVersionUID = -7883379585264199160L;

    @Resource
    @Qualifier("AccessImportService")
    private ImportService importService;

    public String importIndex() throws Exception{
        return SUCCESS;
    }
    
    public String importAccess() throws Exception {
        ImportDataSource ds = this.getAccessDataSource();
        try {
            this.importService.importData(ds);
            this.addActionMessage("Import successfully!");
        } catch (Exception ex) {
            this.addActionError(ex.getMessage());
            return ERROR;
        }
        return super.execute();
    }

    private ImportDataSource getAccessDataSource() {
        Access2010DataSource ds = new Access2010DataSource();
        AccessDao dao = new AccessDao();
        AccessConnDesc connDesc = new AccessConnDesc(this.file);
        dao.setConnDesc(connDesc);
        ds.setDao(dao);
        return ds;
    }
}
