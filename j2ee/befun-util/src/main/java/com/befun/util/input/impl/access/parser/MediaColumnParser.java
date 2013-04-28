package com.befun.util.input.impl.access.parser;

import java.util.Map;

import com.befun.domain.estate.ContentType;
import com.befun.domain.estate.Media;
import com.befun.domain.estate.MediaType;
import com.befun.domain.estate.ModelModification;
import com.befun.util.input.impl.access.AccessUtil;

public class MediaColumnParser implements ColumnParser<Media> {

    @Override
    public Media parse(Map<String, Object> col) {
        Media rs = new Media();
        rs.setAlt(AccessUtil.getString(col, "alt"));
        rs.setBid(AccessUtil.getString(col, "id"));

        Byte contentTypeV = AccessUtil.getByte(col, "content_type");
        ContentType contentType = ContentType.ENVIRONMENT;
        if (contentTypeV != null) {
            contentType = ContentType.getValue(contentTypeV);
        }
        rs.setContentType(contentType);

        
        Byte mediaTypeV = AccessUtil.getByte(col, "media_type");
        MediaType mediaType = MediaType.PICTURE;
        if (mediaTypeV != null) {
            mediaType = MediaType.getValue(mediaTypeV);
        }
        rs.setMediaType(mediaType);

        rs.setLargeUrl(AccessUtil.getString(col, "large_url"));
        rs.setMediumUrl(AccessUtil.getString(col, "medium_url"));
        rs.setSmallUrl(AccessUtil.getString(col, "small_url"));
        rs.setName(AccessUtil.getString(col, "name1"));
        
        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }
}
