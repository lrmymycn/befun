package com.befun.domain.profile;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.befun.domain.Modification;
import com.befun.domain.ModificationModel;

@Entity
@Table(name = "CLIENT_REQUIREMENT")
@TableGenerator(name = "clientRequirementGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "clientRequirement", allocationSize = 1)
public class ClientRequirement implements ModificationModel<Long> {

    private static final long serialVersionUID = -102971164729347498L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "clientRequirementGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "CLIENT_ID")
    private Client client;

    @Column(name = "MIN_PRICE")
    private Integer minPrice;

    @Column(name = "MAX_PRICE")
    private Integer maxPrice;

    @Column(name = "PENTHOUSE")
    private Boolean pentHouse;

    @Column(name = "CAR_PARKING_COUNT_STR")
    private String carParkingCountStr;

    @Column(name = "STORAGEROOM_COUNT_STR")
    private String storageRoomCountStr;

    @Column(name = "FLOORPLAN_TYPE_STR")
    private String floorplanTypeStr;

    @Column(name = "MIN_TOTAL_SIZE")
    private Double minTotalSize;

    @Column(name = "MAX_TOTAL_SIZE")
    private Double maxTotalSize;

    @Column(name = "BEDROOM_COUNT_STR")
    private String bedRoomCountStr;

    @Column(name = "BATHROOM_COUNT_STR")
    private String bathRoomCountStr;

    @Column(name = "COURTYARD_COUNT_STR")
    private String courtyardCountStr;

    @Column(name = "ENCLOSED_BACLONY_COUNT_STR")
    private String enclosedBaclonyCountStr;

    @Column(name = "STUDYROOM_COUNT_STR")
    private String studyroomCountStr;

    @Column(name = "IS_SPLIT")
    private Boolean split;

    @Column(name = "IS_STUDIO")
    private Boolean studio;

    @Column(name = "ORIENTATION_STR")
    private String orientationStr;

    @Column(name = "READY_HOUSE")
    private Boolean readyHouse;

    @Column(name = "SUBURB_ID")
    private Long suburbId;

    @Column(name = "DISTANCE_TO_CITY")
    private Double distanceToCity;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Boolean getPentHouse() {
        return pentHouse;
    }

    public void setPentHouse(Boolean pentHouse) {
        this.pentHouse = pentHouse;
    }

    public String getCarParkingCountStr() {
        return carParkingCountStr;
    }

    public void setCarParkingCountStr(String carParkingCountStr) {
        this.carParkingCountStr = carParkingCountStr;
    }

    public String getStorageRoomCountStr() {
        return storageRoomCountStr;
    }

    public void setStorageRoomCountStr(String storageRoomCountStr) {
        this.storageRoomCountStr = storageRoomCountStr;
    }

    public String getFloorplanTypeStr() {
        return floorplanTypeStr;
    }

    public void setFloorplanTypeStr(String floorplanTypeStr) {
        this.floorplanTypeStr = floorplanTypeStr;
    }

    public Double getMinTotalSize() {
        return minTotalSize;
    }

    public void setMinTotalSize(Double minTotalSize) {
        this.minTotalSize = minTotalSize;
    }

    public Double getMaxTotalSize() {
        return maxTotalSize;
    }

    public void setMaxTotalSize(Double maxTotalSize) {
        this.maxTotalSize = maxTotalSize;
    }

    public String getBedRoomCountStr() {
        return bedRoomCountStr;
    }

    public void setBedRoomCountStr(String bedRoomCountStr) {
        this.bedRoomCountStr = bedRoomCountStr;
    }

    public String getBathRoomCountStr() {
        return bathRoomCountStr;
    }

    public void setBathRoomCountStr(String bathRoomCountStr) {
        this.bathRoomCountStr = bathRoomCountStr;
    }

    public String getCourtyardCountStr() {
        return courtyardCountStr;
    }

    public void setCourtyardCountStr(String courtyardCountStr) {
        this.courtyardCountStr = courtyardCountStr;
    }

    public String getEnclosedBaclonyCountStr() {
        return enclosedBaclonyCountStr;
    }

    public void setEnclosedBaclonyCountStr(String enclosedBaclonyCountStr) {
        this.enclosedBaclonyCountStr = enclosedBaclonyCountStr;
    }

    public String getStudyroomCountStr() {
        return studyroomCountStr;
    }

    public void setStudyroomCountStr(String studyroomCountStr) {
        this.studyroomCountStr = studyroomCountStr;
    }

    public Boolean getSplit() {
        return split;
    }

    public void setSplit(Boolean split) {
        this.split = split;
    }

    public Boolean getStudio() {
        return studio;
    }

    public void setStudio(Boolean studio) {
        this.studio = studio;
    }

    public String getOrientationStr() {
        return orientationStr;
    }

    public void setOrientationStr(String orientationStr) {
        this.orientationStr = orientationStr;
    }

    public Boolean getReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(Boolean readyHouse) {
        this.readyHouse = readyHouse;
    }

    public Long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(Long suburbId) {
        this.suburbId = suburbId;
    }

    public Double getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(Double distanceToCity) {
        this.distanceToCity = distanceToCity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Modification getModification() {
        return modification;
    }

    @Override
    public void setModification(Modification modification) {
        this.modification = modification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bathRoomCountStr == null) ? 0 : bathRoomCountStr.hashCode());
        result = prime * result + ((bedRoomCountStr == null) ? 0 : bedRoomCountStr.hashCode());
        result = prime * result + ((carParkingCountStr == null) ? 0 : carParkingCountStr.hashCode());
        result = prime * result + ((chineseCommunity == null) ? 0 : chineseCommunity.hashCode());
        result = prime * result + ((courtyardCountStr == null) ? 0 : courtyardCountStr.hashCode());
        result = prime * result + ((distanceToCity == null) ? 0 : distanceToCity.hashCode());
        result = prime * result + ((enclosedBaclonyCountStr == null) ? 0 : enclosedBaclonyCountStr.hashCode());
        result = prime * result + ((floorplanTypeStr == null) ? 0 : floorplanTypeStr.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((maxPrice == null) ? 0 : maxPrice.hashCode());
        result = prime * result + ((maxTotalSize == null) ? 0 : maxTotalSize.hashCode());
        result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
        result = prime * result + ((minTotalSize == null) ? 0 : minTotalSize.hashCode());
        result = prime * result + ((modification == null) ? 0 : modification.hashCode());
        result = prime * result + ((orientationStr == null) ? 0 : orientationStr.hashCode());
        result = prime * result + ((pentHouse == null) ? 0 : pentHouse.hashCode());
        result = prime * result + ((readyHouse == null) ? 0 : readyHouse.hashCode());
        result = prime * result + ((schools == null) ? 0 : schools.hashCode());
        result = prime * result + ((shoppingCenter == null) ? 0 : shoppingCenter.hashCode());
        result = prime * result + ((split == null) ? 0 : split.hashCode());
        result = prime * result + ((storageRoomCountStr == null) ? 0 : storageRoomCountStr.hashCode());
        result = prime * result + ((studio == null) ? 0 : studio.hashCode());
        result = prime * result + ((studyroomCountStr == null) ? 0 : studyroomCountStr.hashCode());
        result = prime * result + ((suburbId == null) ? 0 : suburbId.hashCode());
        result = prime * result + ((train == null) ? 0 : train.hashCode());
        result = prime * result + ((universities == null) ? 0 : universities.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ClientRequirement other = (ClientRequirement) obj;
        if (bathRoomCountStr == null) {
            if (other.bathRoomCountStr != null) return false;
        } else if (!bathRoomCountStr.equals(other.bathRoomCountStr)) return false;
        if (bedRoomCountStr == null) {
            if (other.bedRoomCountStr != null) return false;
        } else if (!bedRoomCountStr.equals(other.bedRoomCountStr)) return false;
        if (carParkingCountStr == null) {
            if (other.carParkingCountStr != null) return false;
        } else if (!carParkingCountStr.equals(other.carParkingCountStr)) return false;
        if (chineseCommunity == null) {
            if (other.chineseCommunity != null) return false;
        } else if (!chineseCommunity.equals(other.chineseCommunity)) return false;
        if (courtyardCountStr == null) {
            if (other.courtyardCountStr != null) return false;
        } else if (!courtyardCountStr.equals(other.courtyardCountStr)) return false;
        if (distanceToCity == null) {
            if (other.distanceToCity != null) return false;
        } else if (!distanceToCity.equals(other.distanceToCity)) return false;
        if (enclosedBaclonyCountStr == null) {
            if (other.enclosedBaclonyCountStr != null) return false;
        } else if (!enclosedBaclonyCountStr.equals(other.enclosedBaclonyCountStr)) return false;
        if (floorplanTypeStr == null) {
            if (other.floorplanTypeStr != null) return false;
        } else if (!floorplanTypeStr.equals(other.floorplanTypeStr)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (maxPrice == null) {
            if (other.maxPrice != null) return false;
        } else if (!maxPrice.equals(other.maxPrice)) return false;
        if (maxTotalSize == null) {
            if (other.maxTotalSize != null) return false;
        } else if (!maxTotalSize.equals(other.maxTotalSize)) return false;
        if (minPrice == null) {
            if (other.minPrice != null) return false;
        } else if (!minPrice.equals(other.minPrice)) return false;
        if (minTotalSize == null) {
            if (other.minTotalSize != null) return false;
        } else if (!minTotalSize.equals(other.minTotalSize)) return false;
        if (modification == null) {
            if (other.modification != null) return false;
        } else if (!modification.equals(other.modification)) return false;
        if (orientationStr == null) {
            if (other.orientationStr != null) return false;
        } else if (!orientationStr.equals(other.orientationStr)) return false;
        if (pentHouse == null) {
            if (other.pentHouse != null) return false;
        } else if (!pentHouse.equals(other.pentHouse)) return false;
        if (readyHouse == null) {
            if (other.readyHouse != null) return false;
        } else if (!readyHouse.equals(other.readyHouse)) return false;
        if (schools == null) {
            if (other.schools != null) return false;
        } else if (!schools.equals(other.schools)) return false;
        if (shoppingCenter == null) {
            if (other.shoppingCenter != null) return false;
        } else if (!shoppingCenter.equals(other.shoppingCenter)) return false;
        if (split == null) {
            if (other.split != null) return false;
        } else if (!split.equals(other.split)) return false;
        if (storageRoomCountStr == null) {
            if (other.storageRoomCountStr != null) return false;
        } else if (!storageRoomCountStr.equals(other.storageRoomCountStr)) return false;
        if (studio == null) {
            if (other.studio != null) return false;
        } else if (!studio.equals(other.studio)) return false;
        if (studyroomCountStr == null) {
            if (other.studyroomCountStr != null) return false;
        } else if (!studyroomCountStr.equals(other.studyroomCountStr)) return false;
        if (suburbId == null) {
            if (other.suburbId != null) return false;
        } else if (!suburbId.equals(other.suburbId)) return false;
        if (train == null) {
            if (other.train != null) return false;
        } else if (!train.equals(other.train)) return false;
        if (universities == null) {
            if (other.universities != null) return false;
        } else if (!universities.equals(other.universities)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClientRequirement [id=" + id + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", pentHouse=" + pentHouse + ", carParkingCountStr="
               + carParkingCountStr + ", storageRoomCountStr=" + storageRoomCountStr + ", floorplanTypeStr=" + floorplanTypeStr + ", minTotalSize="
               + minTotalSize + ", maxTotalSize=" + maxTotalSize + ", bedRoomCountStr=" + bedRoomCountStr + ", bathRoomCountStr=" + bathRoomCountStr
               + ", courtyardCountStr=" + courtyardCountStr + ", enclosedBaclonyCountStr=" + enclosedBaclonyCountStr + ", studyroomCountStr="
               + studyroomCountStr + ", split=" + split + ", studio=" + studio + ", orientationStr=" + orientationStr + ", readyHouse=" + readyHouse
               + ", suburbId=" + suburbId + ", distanceToCity=" + distanceToCity + ", universities=" + universities + ", schools=" + schools
               + ", shoppingCenter=" + shoppingCenter + ", train=" + train + ", chineseCommunity=" + chineseCommunity + ", modification=" + modification + "]";
    }

}
