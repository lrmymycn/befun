package com.befun.web.view.converter;

import java.util.ArrayList;
import java.util.List;

import com.befun.domain.BaseModel;
import com.befun.domain.estate.ModelModification;
import com.befun.web.view.BaseView;

public abstract class AbstractViewConverter<M extends BaseModel<?>, V extends BaseView<M>> implements ViewConverter<M, V> {

    public void copyModelModification(ModelModification source, V target) {
        target.setCreationDate(source.getCreationDate());
        target.setEnabled(source.isEnabled());
        target.setLastModifiedDate(source.getLastModifiedDate());
        target.setRemoved(source.isRemoved());
    }

    public String[] generateIgnoredProps(String[] ignoredProperties, List<String> externalIgnoredProperties) {
        List<String> ignoredProps = new ArrayList<String>();
        for (String p : ignoredProperties) {
            ignoredProps.add(p);
        }
        if (externalIgnoredProperties != null) {
            ignoredProps.addAll(externalIgnoredProperties);
        }
        return ignoredProps.toArray(new String[] {});
    }

    @Override
    public V convertToView(M model) {
        return convertToView(model, getDefaultMToVIgnoredProps());
    }

    @Override
    public V convertToView(M model, String[] ignoredProperties) {
        V view = this.generateView(model, null);
        convertToView(model, view, ignoredProperties);
        return view;
    }

    @Override
    public V convertToView(M model, List<String> externalIgnoredProperties) {
        String[] ignoredProperties = generateIgnoredProps(getDefaultMToVIgnoredProps(), externalIgnoredProperties);
        return this.convertToView(model, ignoredProperties);
    }

    @Override
    public void convertToView(M model, V view) {
        this.convertToView(model, view, getDefaultMToVIgnoredProps());
    }

    @Override
    public void convertToView(M model, V view, List<String> externalIgnoredProperties) {
        String[] ignoredProperties = generateIgnoredProps(getDefaultMToVIgnoredProps(), externalIgnoredProperties);
        this.convertToView(model, view, ignoredProperties);
    }

    @Override
    public M convertToModel(V view) {
        return this.convertToModel(view, getDefaultVToMIgnoredProps());
    }

    @Override
    public M convertToModel(V view, String[] ignoredProperties) {
        M model = this.generateModel(null);
        this.convertToModel(view, model, ignoredProperties);
        return model;
    }

    @Override
    public M convertToModel(V view, List<String> externalIgnoredProperties) {
        String[] ignoredProperties = generateIgnoredProps(getDefaultVToMIgnoredProps(), externalIgnoredProperties);
        return this.convertToModel(view, ignoredProperties);
    }

    @Override
    public void convertToModel(V view, M model) {
        this.convertToModel(view, model, getDefaultVToMIgnoredProps());
    }

    @Override
    public void convertToModel(V view, M model, List<String> externalIgnoredProperties) {
        String[] ignoredProperties = generateIgnoredProps(getDefaultVToMIgnoredProps(), externalIgnoredProperties);
        this.convertToModel(view, model, ignoredProperties);
    }
}
