package com.befun.web.action.admin.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.ContentType;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.MediaType;
import com.befun.service.estate.MediaService;
import com.befun.service.query.estate.MediaQueryCondition;
import com.befun.web.action.admin.AdminAction;
import com.befun.web.view.MediaView;
import com.befun.web.view.converter.ConverterFactory;
import com.befun.web.view.converter.ViewConverter;

@Controller("AdminMediaAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MediaAction<T extends Media, V extends MediaView> extends AdminAction<Media, MediaView> {

    private static final long serialVersionUID = 1423434908904040130L;

    private MediaQueryCondition qc = new MediaQueryCondition();

    private File file;

    private static List<MediaType> mediaTypes = new ArrayList<MediaType>();

    private static List<ContentType> contentTypes = new ArrayList<ContentType>();
    
    {
        if (mediaTypes.size() < 1) {
            mediaTypes.add(MediaType.PICTURE);
            mediaTypes.add(MediaType.FILE);
            mediaTypes.add(MediaType.VIDEO);
        }
        if (contentTypes.size() < 1) {
            contentTypes.add(ContentType.FLOORPLAN);
            contentTypes.add(ContentType.FLOORPLATE);
            contentTypes.add(ContentType.ENVIRONMENT);
            contentTypes.add(ContentType.PHOTOGRAPH);
            contentTypes.add(ContentType.RENDER_EXTERNAL);
            contentTypes.add(ContentType.RENDER_INTERNAL);
            contentTypes.add(ContentType.OTHER);
        }
    }

    @Resource
    @Qualifier("MediaService")
    private MediaService service;

    @Override
    public String create() {
        Media model = this.getConverter().convertToModel(this.view);
        this.getService().save(model);
        return SUCCESS;
    }

    @Override
    public String update() {
        Media model = this.getConverter().convertToModel(this.view);
        this.getService().update(model);
        return SUCCESS;
    }

    public void setQc(MediaQueryCondition qc) {
        this.qc = qc;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<MediaType> getMediaTypes() {
        return mediaTypes;
    }

    public List<ContentType> getContentTypes() {
        return contentTypes;
    }

    @Override
    public MediaQueryCondition getQc() {
        return qc;
    }

    public MediaView getView() {
        return this.view;
    }

    public void setView(MediaView view) {
        this.view = view;
    }

    @Override
    public ViewConverter<Media, MediaView> getConverter() {
        return ConverterFactory.getConverter(Media.class);
    }

    @Override
    public MediaService getService() {
        return this.service;
    }

}
