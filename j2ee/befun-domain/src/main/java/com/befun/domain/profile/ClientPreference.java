package com.befun.domain.profile;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.ModificationModel;
import com.befun.domain.Modification;

@Entity
@Table(name = "CLIENT_PREFERENCE")
@TableGenerator(name = "clientPreferenceGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "clientPreference", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "profile")
public class ClientPreference implements ModificationModel<Long> {

    private static final long serialVersionUID = -6858324543891644304L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "clientPreferenceGenerator")
    private Long id;

    @Column(name = "FLOORPLAN_TYPE")
    private String floorplanType;

    @Column(name = "AREA")
    private String area;

    @Column(name = "DISTANCE_TO_CITY")
    private String distanceToCity;

    @Column(name = "BEDROOM")
    private String bedroom;

    @Column(name = "BATHROOM")
    private String bathroom;

    @Column(name = "STUDYROOM")
    private String studyroom;

    @Column(name = "PRICE_RANGE")
    private String priceRange;

    @Column(name = "READY_HOUSE")
    private String readyHouse;

    @Column(name = "TRAINS")
    private String trains;

    @Column(name = "SHOPPING_CENTRES")
    private String shoppingCentres;

    @Column(name = "SCHOOLS")
    private String schools;

    @Column(name = "WATER_VIEW")
    private String waterView;

    @Column(name = "CITY_VIEW")
    private String cityView;

    @Column(name = "HIGH_QUALITY_FINISH")
    private String highQualityFinish;

    @Column(name = "LUXURY")
    private String luxury;

    @Column(name = "GOOD_LIVE_ENV")
    private String goodLiveEnv;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private Modification modification = Modification.createDefault();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFloorplanType() {
        return floorplanType;
    }

    public void setFloorplanType(String floorplanType) {
        this.floorplanType = floorplanType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(String distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getStudyroom() {
        return studyroom;
    }

    public void setStudyroom(String studyroom) {
        this.studyroom = studyroom;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(String readyHouse) {
        this.readyHouse = readyHouse;
    }

    public String getTrains() {
        return trains;
    }

    public void setTrains(String trains) {
        this.trains = trains;
    }

    public String getShoppingCentres() {
        return shoppingCentres;
    }

    public void setShoppingCentres(String shoppingCentres) {
        this.shoppingCentres = shoppingCentres;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    public String getWaterView() {
        return waterView;
    }

    public void setWaterView(String waterView) {
        this.waterView = waterView;
    }

    public String getCityView() {
        return cityView;
    }

    public void setCityView(String cityView) {
        this.cityView = cityView;
    }

    public String getHighQualityFinish() {
        return highQualityFinish;
    }

    public void setHighQualityFinish(String highQualityFinish) {
        this.highQualityFinish = highQualityFinish;
    }

    public String getLuxury() {
        return luxury;
    }

    public void setLuxury(String luxury) {
        this.luxury = luxury;
    }

    public String getGoodLiveEnv() {
        return goodLiveEnv;
    }

    public void setGoodLiveEnv(String goodLiveEnv) {
        this.goodLiveEnv = goodLiveEnv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Modification getModification() {
        return modification;
    }

    public void setModification(Modification modification) {
        this.modification = modification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        result = prime * result + ((bathroom == null) ? 0 : bathroom.hashCode());
        result = prime * result + ((bedroom == null) ? 0 : bedroom.hashCode());
        result = prime * result + ((cityView == null) ? 0 : cityView.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((distanceToCity == null) ? 0 : distanceToCity.hashCode());
        result = prime * result + ((floorplanType == null) ? 0 : floorplanType.hashCode());
        result = prime * result + ((goodLiveEnv == null) ? 0 : goodLiveEnv.hashCode());
        result = prime * result + ((highQualityFinish == null) ? 0 : highQualityFinish.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((luxury == null) ? 0 : luxury.hashCode());
        result = prime * result + ((priceRange == null) ? 0 : priceRange.hashCode());
        result = prime * result + ((readyHouse == null) ? 0 : readyHouse.hashCode());
        result = prime * result + ((schools == null) ? 0 : schools.hashCode());
        result = prime * result + ((shoppingCentres == null) ? 0 : shoppingCentres.hashCode());
        result = prime * result + ((studyroom == null) ? 0 : studyroom.hashCode());
        result = prime * result + ((trains == null) ? 0 : trains.hashCode());
        result = prime * result + ((waterView == null) ? 0 : waterView.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ClientPreference other = (ClientPreference) obj;
        if (area == null) {
            if (other.area != null) return false;
        } else if (!area.equals(other.area)) return false;
        if (bathroom == null) {
            if (other.bathroom != null) return false;
        } else if (!bathroom.equals(other.bathroom)) return false;
        if (bedroom == null) {
            if (other.bedroom != null) return false;
        } else if (!bedroom.equals(other.bedroom)) return false;
        if (cityView == null) {
            if (other.cityView != null) return false;
        } else if (!cityView.equals(other.cityView)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (distanceToCity == null) {
            if (other.distanceToCity != null) return false;
        } else if (!distanceToCity.equals(other.distanceToCity)) return false;
        if (floorplanType == null) {
            if (other.floorplanType != null) return false;
        } else if (!floorplanType.equals(other.floorplanType)) return false;
        if (goodLiveEnv == null) {
            if (other.goodLiveEnv != null) return false;
        } else if (!goodLiveEnv.equals(other.goodLiveEnv)) return false;
        if (highQualityFinish == null) {
            if (other.highQualityFinish != null) return false;
        } else if (!highQualityFinish.equals(other.highQualityFinish)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (luxury == null) {
            if (other.luxury != null) return false;
        } else if (!luxury.equals(other.luxury)) return false;
        if (priceRange == null) {
            if (other.priceRange != null) return false;
        } else if (!priceRange.equals(other.priceRange)) return false;
        if (readyHouse == null) {
            if (other.readyHouse != null) return false;
        } else if (!readyHouse.equals(other.readyHouse)) return false;
        if (schools == null) {
            if (other.schools != null) return false;
        } else if (!schools.equals(other.schools)) return false;
        if (shoppingCentres == null) {
            if (other.shoppingCentres != null) return false;
        } else if (!shoppingCentres.equals(other.shoppingCentres)) return false;
        if (studyroom == null) {
            if (other.studyroom != null) return false;
        } else if (!studyroom.equals(other.studyroom)) return false;
        if (trains == null) {
            if (other.trains != null) return false;
        } else if (!trains.equals(other.trains)) return false;
        if (waterView == null) {
            if (other.waterView != null) return false;
        } else if (!waterView.equals(other.waterView)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClientPreference [id=" + id + ", floorplanType=" + floorplanType + ", area=" + area + ", distanceToCity=" + distanceToCity + ", bedroom="
               + bedroom + ", bathroom=" + bathroom + ", studyroom=" + studyroom + ", priceRange=" + priceRange + ", readyHouse=" + readyHouse + ", trains="
               + trains + ", shoppingCentres=" + shoppingCentres + ", schools=" + schools + ", waterView=" + waterView + ", cityView=" + cityView
               + ", highQualityFinish=" + highQualityFinish + ", luxury=" + luxury + ", goodLiveEnv=" + goodLiveEnv + ", description=" + description + "]";
    }

}
