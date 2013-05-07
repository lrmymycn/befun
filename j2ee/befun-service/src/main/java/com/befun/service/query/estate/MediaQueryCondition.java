package com.befun.service.query.estate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.befun.domain.estate.ContentType;
import com.befun.domain.estate.MediaType;
import com.befun.service.query.QCUtils;
import com.befun.service.query.QueryConstants;

public class MediaQueryCondition extends EstateQueryCondition {

    private static final long serialVersionUID = 1574250681229084211L;

    private MediaType mediaType;

    private ContentType contentType;

    private String key;

    public MediaQueryCondition() {
        super();
        this.setSelfAlias(QueryConstants.ALIAS_MEDIA);
    }

    public MediaQueryCondition(String selfAlias) {
        super(selfAlias);
    }

    @Override
    public List<Criterion> getCriterions() {
        List<Criterion> rs = new ArrayList<Criterion>();
        rs.addAll(super.getCriterions());
        Criterion tmp = null;
        if (this.mediaType != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "mediaType"), this.mediaType);
            rs.add(tmp);
        }
        if (this.contentType != null) {
            tmp = Restrictions.eq(QCUtils.generatePropertyName(this.getSelfAlias(), "contentType"), this.contentType);
            rs.add(tmp);
        }
        if (this.key != null) {
            tmp = Restrictions.or(Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "name"), this.key, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "largeUrl"), this.key, MatchMode.ANYWHERE),
                                  Restrictions.like(QCUtils.generatePropertyName(this.getSelfAlias(), "alt"), this.key, MatchMode.ANYWHERE));
            rs.add(tmp);
        }

        return rs;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        return "MediaQueryCondition [mediaType=" + mediaType + ", contentType=" + contentType + ", key=" + key + ", toString()=" + super.toString() + "]";
    }

}
