package com.befun.domain.estate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "FLOORPLAN")
@TableGenerator(name = "floorplanGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "floorplan", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "floorplan")
public class Floorplan implements BaseEstateModel<Long> {

    private static final long serialVersionUID = 5280230557941296504L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "floorplanGenerator")
    private Long id;

    @Column(name = "BID", length = 255)
    private String bid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "BUILDING_ID")
    private Building building;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "PUBLIC_PICTURE_ID")
    private Media publicPicture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "SALE_PICTURE_ID")
    private Media salePicture;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TYPE")
    @Enumerated(EnumType.ORDINAL)
    private FloorplanType type;

    @Column(name = "IS_SPLIT")
    private boolean split;

    @Column(name = "IS_STUDIO")
    private boolean studio;

    @Column(name = "BEDROOM_COUNT")
    private Short bedRoomCount;

    @Column(name = "BATHROOM_COUNT")
    private Short bathroomCount;

    @Column(name = "STUDYROOM_COUNT")
    private Short studyroomCount;

    @Column(name = "OPEN_BACLONY_COUNT")
    private Short openBaclonyCount;

    @Column(name = "ENCLOSED_BACLONY_COUNT")
    private Short enclosedBaclonyCount;

    @Column(name = "COURTYARD_COUNT")
    private Short courtyardCount;

    @Column(name = "ORIENTATION_EAST")
    private Boolean orientationEast;

    @Column(name = "ORIENTATION_SOUTH")
    private Boolean orientationSouth;

    @Column(name = "ORIENTATION_WEST")
    private Boolean orientationWest;

    @Column(name = "ORIENTATION_NORTH")
    private Boolean orientationNorth;

    @Column(name = "MIN_PRICE")
    private Integer minPrice;

    @Column(name = "MAX_PRICE")
    private Integer maxPrice;

    @Column(name = "INTERNAL_SIZE")
    private Double internalSize;

    @Column(name = "EXTERNAL_SIZE")
    private Double externalSize;

    @Column(name = "TOTAL_SIZE")
    private Double totalSize;

    @Column(name = "LAND_SIZE")
    private Double landSize;

    @Column(name = "SOLD")
    private Integer sold;

    @Column(name = "SOLD_OUT")
    private boolean soldOut;

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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Media getPublicPicture() {
        return publicPicture;
    }

    public void setPublicPicture(Media publicPicture) {
        this.publicPicture = publicPicture;
    }

    public Media getSalePicture() {
        return salePicture;
    }

    public void setSalePicture(Media salePicture) {
        this.salePicture = salePicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FloorplanType getType() {
        return type;
    }

    public void setType(FloorplanType type) {
        this.type = type;
    }

    public boolean isSplit() {
        return split;
    }

    public void setSplit(boolean split) {
        this.split = split;
    }

    public boolean isStudio() {
        return studio;
    }

    public void setStudio(boolean studio) {
        this.studio = studio;
    }

    public Short getBedRoomCount() {
        return bedRoomCount;
    }

    public void setBedRoomCount(Short bedRoomCount) {
        this.bedRoomCount = bedRoomCount;
    }

    public Short getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(Short bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public Short getStudyroomCount() {
        return studyroomCount;
    }

    public void setStudyroomCount(Short studyroomCount) {
        this.studyroomCount = studyroomCount;
    }

    public Short getOpenBaclonyCount() {
        return openBaclonyCount;
    }

    public void setOpenBaclonyCount(Short openBaclonyCount) {
        this.openBaclonyCount = openBaclonyCount;
    }

    public Short getEnclosedBaclonyCount() {
        return enclosedBaclonyCount;
    }

    public void setEnclosedBaclonyCount(Short enclosedBaclonyCount) {
        this.enclosedBaclonyCount = enclosedBaclonyCount;
    }

    public Short getCourtyardCount() {
        return courtyardCount;
    }

    public void setCourtyardCount(Short courtyardCount) {
        this.courtyardCount = courtyardCount;
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

    public Double getInternalSize() {
        return internalSize;
    }

    public void setInternalSize(Double internalSize) {
        this.internalSize = internalSize;
    }

    public Double getExternalSize() {
        return externalSize;
    }

    public void setExternalSize(Double externalSize) {
        this.externalSize = externalSize;
    }

    public Double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Double totalSize) {
        this.totalSize = totalSize;
    }

    public Double getLandSize() {
        return landSize;
    }

    public void setLandSize(Double landSize) {
        this.landSize = landSize;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public ModelModification getModelModification() {
        return modelModification;
    }

    public void setModelModification(ModelModification modelModification) {
        this.modelModification = modelModification;
    }

    public Boolean getOrientationEast() {
        return orientationEast;
    }

    public void setOrientationEast(Boolean orientationEast) {
        this.orientationEast = orientationEast;
    }

    public Boolean getOrientationSouth() {
        return orientationSouth;
    }

    public void setOrientationSouth(Boolean orientationSouth) {
        this.orientationSouth = orientationSouth;
    }

    public Boolean getOrientationWest() {
        return orientationWest;
    }

    public void setOrientationWest(Boolean orientationWest) {
        this.orientationWest = orientationWest;
    }

    public Boolean getOrientationNorth() {
        return orientationNorth;
    }

    public void setOrientationNorth(Boolean orientationNorth) {
        this.orientationNorth = orientationNorth;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bathroomCount == null) ? 0 : bathroomCount.hashCode());
        result = prime * result + ((bedRoomCount == null) ? 0 : bedRoomCount.hashCode());
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((courtyardCount == null) ? 0 : courtyardCount.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((enclosedBaclonyCount == null) ? 0 : enclosedBaclonyCount.hashCode());
        result = prime * result + ((externalSize == null) ? 0 : externalSize.hashCode());
        result = prime * result + ((internalSize == null) ? 0 : internalSize.hashCode());
        result = prime * result + ((landSize == null) ? 0 : landSize.hashCode());
        result = prime * result + ((maxPrice == null) ? 0 : maxPrice.hashCode());
        result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + ((openBaclonyCount == null) ? 0 : openBaclonyCount.hashCode());
        result = prime * result + ((orientationEast == null) ? 0 : orientationEast.hashCode());
        result = prime * result + ((orientationNorth == null) ? 0 : orientationNorth.hashCode());
        result = prime * result + ((orientationSouth == null) ? 0 : orientationSouth.hashCode());
        result = prime * result + ((orientationWest == null) ? 0 : orientationWest.hashCode());
        result = prime * result + ((sold == null) ? 0 : sold.hashCode());
        result = prime * result + (soldOut ? 1231 : 1237);
        result = prime * result + (split ? 1231 : 1237);
        result = prime * result + (studio ? 1231 : 1237);
        result = prime * result + ((studyroomCount == null) ? 0 : studyroomCount.hashCode());
        result = prime * result + ((totalSize == null) ? 0 : totalSize.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Floorplan other = (Floorplan) obj;
        if (bathroomCount == null) {
            if (other.bathroomCount != null) return false;
        } else if (!bathroomCount.equals(other.bathroomCount)) return false;
        if (bedRoomCount == null) {
            if (other.bedRoomCount != null) return false;
        } else if (!bedRoomCount.equals(other.bedRoomCount)) return false;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (courtyardCount == null) {
            if (other.courtyardCount != null) return false;
        } else if (!courtyardCount.equals(other.courtyardCount)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (enclosedBaclonyCount == null) {
            if (other.enclosedBaclonyCount != null) return false;
        } else if (!enclosedBaclonyCount.equals(other.enclosedBaclonyCount)) return false;
        if (externalSize == null) {
            if (other.externalSize != null) return false;
        } else if (!externalSize.equals(other.externalSize)) return false;
        if (internalSize == null) {
            if (other.internalSize != null) return false;
        } else if (!internalSize.equals(other.internalSize)) return false;
        if (landSize == null) {
            if (other.landSize != null) return false;
        } else if (!landSize.equals(other.landSize)) return false;
        if (maxPrice == null) {
            if (other.maxPrice != null) return false;
        } else if (!maxPrice.equals(other.maxPrice)) return false;
        if (minPrice == null) {
            if (other.minPrice != null) return false;
        } else if (!minPrice.equals(other.minPrice)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (openBaclonyCount == null) {
            if (other.openBaclonyCount != null) return false;
        } else if (!openBaclonyCount.equals(other.openBaclonyCount)) return false;
        if (orientationEast == null) {
            if (other.orientationEast != null) return false;
        } else if (!orientationEast.equals(other.orientationEast)) return false;
        if (orientationNorth == null) {
            if (other.orientationNorth != null) return false;
        } else if (!orientationNorth.equals(other.orientationNorth)) return false;
        if (orientationSouth == null) {
            if (other.orientationSouth != null) return false;
        } else if (!orientationSouth.equals(other.orientationSouth)) return false;
        if (orientationWest == null) {
            if (other.orientationWest != null) return false;
        } else if (!orientationWest.equals(other.orientationWest)) return false;
        if (sold == null) {
            if (other.sold != null) return false;
        } else if (!sold.equals(other.sold)) return false;
        if (soldOut != other.soldOut) return false;
        if (split != other.split) return false;
        if (studio != other.studio) return false;
        if (studyroomCount == null) {
            if (other.studyroomCount != null) return false;
        } else if (!studyroomCount.equals(other.studyroomCount)) return false;
        if (totalSize == null) {
            if (other.totalSize != null) return false;
        } else if (!totalSize.equals(other.totalSize)) return false;
        if (type != other.type) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Floorplan [id=" + id + ", bid=" + bid + ", description=" + description + ", type=" + type + ", split=" + split + ", studio=" + studio
               + ", bedRoomCount=" + bedRoomCount + ", bathroomCount=" + bathroomCount + ", studyroomCount=" + studyroomCount + ", openBaclonyCount="
               + openBaclonyCount + ", enclosedBaclonyCount=" + enclosedBaclonyCount + ", courtyardCount=" + courtyardCount + ", orientationEast="
               + orientationEast + ", orientationSouth=" + orientationSouth + ", orientationWest=" + orientationWest + ", orientationNorth=" + orientationNorth
               + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", internalSize=" + internalSize + ", externalSize=" + externalSize + ", totalSize="
               + totalSize + ", landSize=" + landSize + ", sold=" + sold + ", soldOut=" + soldOut + ", modelModification=" + modelModification + "]";
    }

}
