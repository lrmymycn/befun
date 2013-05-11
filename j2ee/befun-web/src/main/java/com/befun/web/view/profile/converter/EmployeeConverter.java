package com.befun.web.view.profile.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.profile.Employee;
import com.befun.web.view.profile.EmployeeView;

public class EmployeeConverter extends AbstractProfileViewConverter<Employee, EmployeeView> {

    public final static String[] IGNORED_PROPS_MODEL_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_MODEL = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_MODEL_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_MODEL;
    }

    @Override
    public void convertToView(Employee model, EmployeeView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
    }

    @Override
    public void convertToModel(EmployeeView view, Employee model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public Employee generateModel(Object params) {
        return new Employee();
    }

    @Override
    public EmployeeView generateView(Employee model, Object params) {
        return new EmployeeView(model);
    }

}
