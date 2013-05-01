package com.befun.domain.estate;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "AREA")
@TableGenerator(name = "areaGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "area", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "geography")
public class Area implements BaseEstateModel<Long> {

    private static final long serialVersionUID = -1911564613374735429L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "areaGenerator")
    private Long id;

    @Column(name = "BID", length = 255)
    private String bid;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("seqNum ASC")
    private List<AreaPolyline> polylines;

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    private Set<Suburb> suburbs;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public List<AreaPolyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<AreaPolyline> polylines) {
        this.polylines = polylines;
    }

    public Set<Suburb> getSuburbs() {
        return suburbs;
    }

    public void setSuburbs(Set<Suburb> suburbs) {
        this.suburbs = suburbs;
    }

    public ModelModification getModelModification() {
        return modelModification;
    }

    public void setModelModification(ModelModification pModelModification) {
        modelModification = pModelModification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Area other = (Area) obj;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (latitude == null) {
            if (other.latitude != null) return false;
        } else if (!latitude.equals(other.latitude)) return false;
        if (longitude == null) {
            if (other.longitude != null) return false;
        } else if (!longitude.equals(other.longitude)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Area [id=" + id + ", bid=" + bid + ", name=" + name + ", description=" + description + ", longitude=" + longitude + ", latitude=" + latitude
               + ", modelModification=" + modelModification + "]";
    }

}
