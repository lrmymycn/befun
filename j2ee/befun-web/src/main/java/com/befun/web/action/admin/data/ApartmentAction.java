package com.befun.web.action.admin.data;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Apartment;
import com.befun.service.IBaseService;
import com.befun.service.estate.ApartmentService;
import com.befun.service.query.ApartmentQueryCondition;
import com.befun.web.action.JmesaAction;
import com.befun.web.view.ApartmentView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminApartmentAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApartmentAction extends JmesaAction<Apartment, ApartmentView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private ApartmentQueryCondition qc;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService service;

    /*
     * private void jmesa() {
     * HttpServletRequest request = this.getRequest();
     * TableModel tableModel = new TableModel("views", request);
     * 
     * tableModel.setItems(new PageItems() {
     * 
     * public int getTotalRows(Limit limit) {
     * return (int)pgb.getTotalCount();
     * }
     * 
     * public Collection<?> getItems(Limit limit) {
     * int start = limit.getRowSelect().getRowStart();
     * int end = limit.getRowSelect().getRowEnd();
     * FilterSet fs = limit.getFilterSet();
     * for (Filter f : fs.getFilters()) {
     * // 如果需要条件过滤的话可以这样去的过滤条件
     * System.out.println(f.getProperty() + "=" + f.getValue());
     * }
     * 
     * return pgb.getModels();
     * }
     * 
     * });
     * tableModel.setTable(getTable());
     * String html = tableModel.render();
     * request.setAttribute("dynaTable", html);
     * }
     * 
     * private HtmlTable getTable() {
     * HtmlTable htmlTable = new HtmlTable().caption("Apartment List").width("600px");
     * 
     * HtmlRow htmlRow = new HtmlRow();
     * htmlTable.setRow(htmlRow);
     * 
     * HtmlColumn id = new HtmlColumn("id");
     * htmlRow.addColumn(id);
     * 
     * HtmlColumn name = new HtmlColumn("description");
     * htmlRow.addColumn(name);
     * 
     * HtmlColumn password = new HtmlColumn("lotNumber");
     * htmlRow.addColumn(password);
     * 
     * HtmlColumn sex = new HtmlColumn("price");
     * htmlRow.addColumn(sex);
     * 
     * HtmlColumn soldOut = new HtmlColumn("soldOut");
     * htmlRow.addColumn(soldOut);
     * 
     * HtmlColumn enabled = new HtmlColumn("enabled");
     * htmlRow.addColumn(enabled);
     * 
     * HtmlColumn delete = new HtmlColumn("Remove");
     * delete.setCellEditor(new CellEditor() {
     * 
     * public Object getValue(Object item, String property, int rowcount) {
     * ApartmentView v = (ApartmentView) item;
     * HtmlBuilder builder = new HtmlBuilder();
     * String js = "javascript:void(0);" + v.getFloorplanId();
     * js = ApartmentAction.this.getRequest().getContextPath() + "/admin/data/removeapartment.action";
     * builder.a().href(js).close();
     * builder.append("删除");
     * builder.aEnd();
     * return builder.toString();
     * }
     * });
     * htmlRow.addColumn(delete);
     * htmlRow.setUniqueProperty("id");
     * return htmlTable;
     * }
     */

    public void setQc(ApartmentQueryCondition qc) {
        this.qc = qc;
    }

    @Override
    public ApartmentQueryCondition getQc() {
        return qc;
    }

    @Override
    public ApartmentView getView() {
        return this.view;
    }

    @Override
    public void setView(ApartmentView view) {
        this.view = view;
    }

    @Override
    public ViewConverter<Apartment, ApartmentView> getConverter() {
        return ConverterFactory.getConverter(Apartment.class);
    }

    @Override
    public IBaseService<Apartment, Long> getService() {
        return service;
    }

}
