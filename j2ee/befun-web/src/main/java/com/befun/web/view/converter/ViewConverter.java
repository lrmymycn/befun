package com.befun.web.view.converter;

import java.util.List;

import com.befun.domain.BaseModel;
import com.befun.web.view.BaseView;

public interface ViewConverter<M extends BaseModel<?>, V extends BaseView<M>> {

    String[] getDefaultMToVIgnoredProps();

    String[] getDefaultVToMIgnoredProps();

    V convertToView(M model);

    V convertToView(M model, String[] ignoredProperties);

    V convertToView(M model, List<String> externalIgnoredProperties);

    void convertToView(M model, V view);

    void convertToView(M model, V view, String[] ignoredProperties);

    void convertToView(M model, V view, List<String> externalIgnoredProperties);

    M convertToModel(V view);

    M convertToModel(V view, String[] ignoredProperties);

    M convertToModel(V view, List<String> externalIgnoredProperties);

    void convertToModel(V view, M model);

    void convertToModel(V view, M model, String[] ignoredProperties);

    void convertToModel(V view, M model, List<String> externalIgnoredProperties);

    M generateModel(Object params);

    V generateView(M model, Object params);
}
