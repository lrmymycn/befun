package com.befun.web.action;

import java.io.File;

public class FileUploadAction extends BaseAction {

    private static final long serialVersionUID = 5309118968930059400L;

    protected File file;

    public String execute() throws Exception {
        return SUCCESS;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
