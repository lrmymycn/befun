package com.befun.web.view;

import com.befun.domain.estate.ContentType;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.MediaType;

public class MediaView extends BaseView<Media> {

    private static final long serialVersionUID = -1484346576753677173L;

    private String name;

    private String smallUrl;

    private String mediumUrl;

    private String largeUrl;

    private String alt;

    private MediaType mediaType;

    private ContentType contentType;

    public MediaView(Media model) {
        super(model);
    }

    @Override
    public Media getModel() {
        return this.model;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getSmallUrl() {
        return smallUrl;
    }

    
    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    
    public String getMediumUrl() {
        return mediumUrl;
    }

    
    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    
    public String getLargeUrl() {
        return largeUrl;
    }

    
    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    
    public String getAlt() {
        return alt;
    }

    
    public void setAlt(String alt) {
        this.alt = alt;
    }

    
    public MediaType getMediaType() {
        return mediaType;
    }

    
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    
    public ContentType getContentType() {
        return contentType;
    }

    
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "MediaView [name=" + name + ", smallUrl=" + smallUrl + ", mediumUrl=" + mediumUrl + ", largeUrl=" + largeUrl + ", alt=" + alt + ", mediaType="
               + mediaType + ", contentType=" + contentType + ", toString()=" + super.toString() + "]";
    }


}
