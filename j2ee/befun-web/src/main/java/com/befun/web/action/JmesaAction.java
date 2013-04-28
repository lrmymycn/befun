package com.befun.web.action;

import org.apache.commons.lang.StringUtils;
import org.jmesa.limit.Action;

import com.befun.domain.BaseModel;
import com.befun.web.utils.JmesaUtils;
import com.befun.web.view.BaseView;
import com.opensymphony.xwork2.Preparable;

public abstract class JmesaAction<M extends BaseModel<Long>, V extends BaseView<M>> extends CRUDAction<M,V> implements Preparable{

    private static final long serialVersionUID = -4633078816479738427L;

    private String tableName;

    public void prepare() {
        this.pn = this.getPageNum(getTableName());
        this.ps = this.getPageSize(getTableName());
    }

    protected long getPageNum(String tableName) {
        long rs = 1;
        String str = JmesaUtils.getJmesaParam(this.getRequest(), Action.PAGE, tableName);
        if (!StringUtils.isBlank(str)) {
            rs = Long.parseLong(str);
        }
        return rs;
    }

    protected int getPageSize(String tableName) {
        int rs = 20;
        String str = JmesaUtils.getJmesaParam(this.getRequest(), Action.MAX_ROWS, tableName);
        if (!StringUtils.isBlank(str)) {
            rs = Integer.parseInt(str);
        }
        return rs;
    }

    public String getTableName() {
        if(StringUtils.isBlank(this.tableName)){
            this.tableName = this.getRequest().getParameter("tableName");
        }
        return tableName;
    }

}
