package com.befun.domain.estate;

import javax.persistence.Cacheable;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "APARTMENT")
@TableGenerator(name = "apartmentGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "apartment", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="floorplan")
public class Apartment implements BaseEstateModel<Long> {

    private static final long serialVersionUID = 5737500338859325930L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "apartmentGenerator")
    private Long id;

    @Column(name = "BID", length = 255)
    private String bid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "FLOORPLAN_ID")
    private Floorplan floorplan;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UNIT_NUMBER", length = 45)
    private String unitNumber;

    @Column(name = "LOT_NUMBER", length = 45)
    private String lotNumber;

    @Column(name = "FLOOR_LEVEL")
    private Short floorLevel;

    @Column(name = "PENTHOUSE")
    private boolean pentHouse;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "UNIT_ENTITLE_MENT")
    private Short unitEntitlement;

    @Column(name = "COLORSCHEME")
    private String colorScheme;

    @Column(name = "CAR_PARKING_COUNT")
    private Short carParkingCount;

    @Column(name = "STORAGEROOM_COUNT")
    private Short storageRoomCount;

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

    public Floorplan getFloorplan() {
        return floorplan;
    }

    public void setFloorplan(Floorplan floorplan) {
        this.floorplan = floorplan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Short getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(Short floorLevel) {
        this.floorLevel = floorLevel;
    }

    public boolean isPentHouse() {
        return pentHouse;
    }

    public void setPentHouse(boolean pentHouse) {
        this.pentHouse = pentHouse;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Short getUnitEntitlement() {
        return unitEntitlement;
    }

    public void setUnitEntitlement(Short unitEntitlement) {
        this.unitEntitlement = unitEntitlement;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    public Short getCarParkingCount() {
        return carParkingCount;
    }

    public void setCarParkingCount(Short carParkingCount) {
        this.carParkingCount = carParkingCount;
    }

    public Short getStorageRoomCount() {
        return storageRoomCount;
    }

    public void setStorageRoomCount(Short storageRoomCount) {
        this.storageRoomCount = storageRoomCount;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((carParkingCount == null) ? 0 : carParkingCount.hashCode());
        result = prime * result + ((colorScheme == null) ? 0 : colorScheme.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + floorLevel;
        result = prime * result + ((floorplan == null) ? 0 : floorplan.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lotNumber == null) ? 0 : lotNumber.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + (pentHouse ? 1231 : 1237);
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + (soldOut ? 1231 : 1237);
        result = prime * result + ((storageRoomCount == null) ? 0 : storageRoomCount.hashCode());
        result = prime * result + ((unitEntitlement == null) ? 0 : unitEntitlement.hashCode());
        result = prime * result + ((unitNumber == null) ? 0 : unitNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Apartment other = (Apartment) obj;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (carParkingCount == null) {
            if (other.carParkingCount != null) return false;
        } else if (!carParkingCount.equals(other.carParkingCount)) return false;
        if (colorScheme == null) {
            if (other.colorScheme != null) return false;
        } else if (!colorScheme.equals(other.colorScheme)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (floorLevel != other.floorLevel) return false;
        if (floorplan == null) {
            if (other.floorplan != null) return false;
        } else if (!floorplan.equals(other.floorplan)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (lotNumber == null) {
            if (other.lotNumber != null) return false;
        } else if (!lotNumber.equals(other.lotNumber)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (pentHouse != other.pentHouse) return false;
        if (price == null) {
            if (other.price != null) return false;
        } else if (!price.equals(other.price)) return false;
        if (soldOut != other.soldOut) return false;
        if (storageRoomCount == null) {
            if (other.storageRoomCount != null) return false;
        } else if (!storageRoomCount.equals(other.storageRoomCount)) return false;
        if (unitEntitlement == null) {
            if (other.unitEntitlement != null) return false;
        } else if (!unitEntitlement.equals(other.unitEntitlement)) return false;
        if (unitNumber == null) {
            if (other.unitNumber != null) return false;
        } else if (!unitNumber.equals(other.unitNumber)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Apartment [id=" + id + ", bid=" + bid + ", floorplan=" + floorplan + ", description=" + description + ", unitNumber=" + unitNumber
               + ", lotNumber=" + lotNumber + ", floorLevel=" + floorLevel + ", pentHouse=" + pentHouse + ", price=" + price + ", unitEntitlement="
               + unitEntitlement + ", colorScheme=" + colorScheme + ", carParkingCount=" + carParkingCount + ", storageRoomCount=" + storageRoomCount
               + ", soldOut=" + soldOut + ", modelModification=" + modelModification + "]";
    }

}
