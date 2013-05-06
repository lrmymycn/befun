package com.befun.domain.profile;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseModel;

@Entity
@Table(name = "PROJECT_INTEREST_LIST_ITEM")
@TableGenerator(name = "projectInterestListItemGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "projectInterestListItem", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "profile")
public class ProjectInterestListItem implements BaseModel<Long> {

    private static final long serialVersionUID = 2171356704749634553L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "projectInterestListItemGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "INTEREST_LIST_ID")
    private InterestList interestList;

    @Column(name = "PROJECT_ID")
    private Long propertyId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public InterestList getInterestList() {
        return interestList;
    }

    public void setInterestList(InterestList interestList) {
        this.interestList = interestList;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((propertyId == null) ? 0 : propertyId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ProjectInterestListItem other = (ProjectInterestListItem) obj;
        if (creationDate == null) {
            if (other.creationDate != null) return false;
        } else if (!creationDate.equals(other.creationDate)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (propertyId == null) {
            if (other.propertyId != null) return false;
        } else if (!propertyId.equals(other.propertyId)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProjectInterestListItem [id=" + id + ", propertyId=" + propertyId + ", description=" + description + ", creationDate=" + creationDate + "]";
    }

}