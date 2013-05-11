package com.befun.web.view.converter;

import org.springframework.beans.BeanUtils;

import com.befun.domain.estate.Media;
import com.befun.web.view.MediaView;

public class MediaConverter extends AbstractEstateViewConverter<Media, MediaView> {

    public final static String[] IGNORED_PROPS_MEDIA_VIEW = new String[] {};

    public final static String[] IGNORED_PROPS_VIEW_MEDIA = new String[] {};

    @Override
    public String[] getDefaultMToVIgnoredProps() {
        return IGNORED_PROPS_MEDIA_VIEW;
    }

    @Override
    public String[] getDefaultVToMIgnoredProps() {
        return IGNORED_PROPS_VIEW_MEDIA;
    }

    @Override
    public void convertToView(Media model, MediaView view, String[] ignoredProperties) {
        BeanUtils.copyProperties(model, view, ignoredProperties);
        copyModelModification(model.getModelModification(), view);
    }

    @Override
    public void convertToModel(MediaView view, Media model, String[] ignoredProperties) {
        BeanUtils.copyProperties(view, model, ignoredProperties);
    }

    @Override
    public Media generateModel(Object params) {
        return new Media();
    }

    @Override
    public MediaView generateView(Media model, Object params) {
        return new MediaView(model);
    }

}
