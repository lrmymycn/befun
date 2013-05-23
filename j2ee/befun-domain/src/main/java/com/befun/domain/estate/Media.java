package com.befun.domain.estate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "MEDIA")
@TableGenerator(name = "mediaGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "media", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "media")
public class Media implements BaseEstateModel<Long> {

    private static final long serialVersionUID = 4659158480955460910L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "mediaGenerator")
    private Long id;

    @Column(name = "BID", length = 255)
    private String bid;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    private String projectBid;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "SMALL_URL", length = 5000)
    private String smallUrl;

    @Column(name = "MEDIUM_URL", length = 5000)
    private String mediumUrl;

    @Column(name = "LARGE_URL", length = 5000)
    private String largeUrl;

    @Column(name = "ALT", length = 5000)
    private String alt;

    @Column(name = "MEDIA_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private MediaType mediaType;

    @Column(name = "CONTENT_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private ContentType contentType;

    @Embedded
    private ModelModification modelModification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectBid() {
        return projectBid;
    }

    public void setProjectBid(String projectBid) {
        this.projectBid = projectBid;
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

    public ModelModification getModelModification() {
        return modelModification;
    }

    public void setModelModification(ModelModification modelModification) {
        this.modelModification = modelModification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alt == null) ? 0 : alt.hashCode());
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((largeUrl == null) ? 0 : largeUrl.hashCode());
        result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
        result = prime * result + ((mediumUrl == null) ? 0 : mediumUrl.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((smallUrl == null) ? 0 : smallUrl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Media other = (Media) obj;
        if (alt == null) {
            if (other.alt != null) return false;
        } else if (!alt.equals(other.alt)) return false;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (contentType != other.contentType) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (largeUrl == null) {
            if (other.largeUrl != null) return false;
        } else if (!largeUrl.equals(other.largeUrl)) return false;
        if (mediaType != other.mediaType) return false;
        if (mediumUrl == null) {
            if (other.mediumUrl != null) return false;
        } else if (!mediumUrl.equals(other.mediumUrl)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (smallUrl == null) {
            if (other.smallUrl != null) return false;
        } else if (!smallUrl.equals(other.smallUrl)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", bid=" + bid + ", name=" + name + ", smallUrl=" + smallUrl + ", mediumUrl=" + mediumUrl + ", largeUrl=" + largeUrl
               + ", alt=" + alt + ", mediaType=" + mediaType + ", contentType=" + contentType + ", modelModification=" + modelModification + "]";
    }

}
