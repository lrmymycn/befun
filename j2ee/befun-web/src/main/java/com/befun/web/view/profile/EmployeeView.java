package com.befun.web.view.profile;

import com.befun.domain.profile.Employee;

public class EmployeeView extends ProfileView<Employee> {

    private static final long serialVersionUID = 607541607242583262L;

    private String title;

    private String titleDesc;

    private Integer rank = 1;

    private String employeeNumber;

    private String abn;

    private String gst;

    public EmployeeView() {
        super();
    }

    public EmployeeView(Employee model) {
        super(model);
    }

    @Override
    public Employee getModel() {
        return this.model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

}
