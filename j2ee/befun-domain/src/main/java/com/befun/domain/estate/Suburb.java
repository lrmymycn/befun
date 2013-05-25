package com.befun.domain.estate;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "SUBURB")
@TableGenerator(name = "suburbGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "suburb", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="suburb")
public class Suburb implements BaseEstateModel<Long> {

    private static final long serialVersionUID = -2452607355221937007L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "suburbGenerator")
    private Long id;

    @Column(name = "BID", length = 255)
    private String bid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "AREA_ID")
    private Area area;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MASTER_PLAN")
    private String masterPlan;

    @Column(name = "POSTCODE")
    private String postCode;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "VACANCY_RATE")
    private Integer vacancyRate;

    @Column(name = "UNIVERSITIES")
    private Boolean universities;

    @Column(name = "SCHOOLS")
    private Boolean schools;

    @Column(name = "SHOPPING_CENTER")
    private Boolean shoppingCenter;

    @Column(name = "TRAIN")
    private Boolean train;

    @Column(name = "CHINESE_COMMUNITY")
    private Boolean chineseCommunity;

    @OneToMany(mappedBy = "suburb", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("seqNum ASC")
    private List<SuburbPolyline> polylines;

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public String getMasterPlan() {
        return masterPlan;
    }

    public void setMasterPlan(String masterPlan) {
        this.masterPlan = masterPlan;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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

    public Integer getVacancyRate() {
        return vacancyRate;
    }

    public void setVacancyRate(Integer vacancyRate) {
        this.vacancyRate = vacancyRate;
    }

    public Boolean getUniversities() {
        return universities;
    }

    public void setUniversities(Boolean universities) {
        this.universities = universities;
    }

    public Boolean getSchools() {
        return schools;
    }

    public void setSchools(Boolean schools) {
        this.schools = schools;
    }

    public Boolean getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(Boolean shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Boolean getChineseCommunity() {
        return chineseCommunity;
    }

    public void setChineseCommunity(Boolean chineseCommunity) {
        this.chineseCommunity = chineseCommunity;
    }

    public List<SuburbPolyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<SuburbPolyline> polylines) {
        this.polylines = polylines;
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
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((chineseCommunity == null) ? 0 : chineseCommunity.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((masterPlan == null) ? 0 : masterPlan.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
        result = prime * result + ((schools == null) ? 0 : schools.hashCode());
        result = prime * result + ((shoppingCenter == null) ? 0 : shoppingCenter.hashCode());
        result = prime * result + ((train == null) ? 0 : train.hashCode());
        result = prime * result + ((universities == null) ? 0 : universities.hashCode());
        result = prime * result + ((vacancyRate == null) ? 0 : vacancyRate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Suburb other = (Suburb) obj;
        if (area == null) {
            if (other.area != null) return false;
        } else if (!area.equals(other.area)) return false;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (chineseCommunity == null) {
            if (other.chineseCommunity != null) return false;
        } else if (!chineseCommunity.equals(other.chineseCommunity)) return false;
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
        if (masterPlan == null) {
            if (other.masterPlan != null) return false;
        } else if (!masterPlan.equals(other.masterPlan)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (postCode == null) {
            if (other.postCode != null) return false;
        } else if (!postCode.equals(other.postCode)) return false;
        if (schools == null) {
            if (other.schools != null) return false;
        } else if (!schools.equals(other.schools)) return false;
        if (shoppingCenter == null) {
            if (other.shoppingCenter != null) return false;
        } else if (!shoppingCenter.equals(other.shoppingCenter)) return false;
        if (train == null) {
            if (other.train != null) return false;
        } else if (!train.equals(other.train)) return false;
        if (universities == null) {
            if (other.universities != null) return false;
        } else if (!universities.equals(other.universities)) return false;
        if (vacancyRate == null) {
            if (other.vacancyRate != null) return false;
        } else if (!vacancyRate.equals(other.vacancyRate)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Suburb [id=" + id + ", bid=" + bid + ", area=" + area + ", name=" + name + ", description=" + description + ", masterPlan=" + masterPlan
               + ", postCode=" + postCode + ", longitude=" + longitude + ", latitude=" + latitude + ", vacancyRate=" + vacancyRate + ", universities="
               + universities + ", schools=" + schools + ", shoppingCenter=" + shoppingCenter + ", train=" + train + ", chineseCommunity=" + chineseCommunity
               + ", modelModification=" + modelModification + "]";
    }

}
