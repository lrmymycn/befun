package com.befun.domain.estate;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseEstateModel;

@Entity
@Table(name = "BUILDING")
@TableGenerator(name = "buildingGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "building", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="project")
public class Building implements BaseEstateModel<Long> {

    private static final long serialVersionUID = 252518840372470088L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "buildingGenerator")
    private Long id;

    @Column(name = "BID", length = 255)
    private String bid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "STAGE_ID")
    private Stage stage;

    @Column(name = "BUILDING_NUM", length = 255)
    private String buildingNumber;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FINISH_DATE")
    private Date finishDate;

    @Column(name = "FLOOR_COUNT")
    private Short floorCount;

    @Column(name = "ORIENTATION")
    private Short orientation;

    @Column(name = "READY_HOUSE")
    private boolean readyHouse;

    @Column(name = "SOLD")
    private Integer sold;

    @Column(name = "SOLD_OUT")
    private boolean soldOut;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private Set<Floorplan> floorplans;

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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Short getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Short floorCount) {
        this.floorCount = floorCount;
    }

    public Short getOrientation() {
        return orientation;
    }

    public void setOrientation(Short orientation) {
        this.orientation = orientation;
    }

    public boolean isReadyHouse() {
        return readyHouse;
    }

    public void setReadyHouse(boolean readyHouse) {
        this.readyHouse = readyHouse;
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

    public Set<Floorplan> getFloorplans() {
        return floorplans;
    }

    public void setFloorplans(Set<Floorplan> floorplans) {
        this.floorplans = floorplans;
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
        result = prime * result + ((buildingNumber == null) ? 0 : buildingNumber.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((finishDate == null) ? 0 : finishDate.hashCode());
        result = prime * result + ((floorCount == null) ? 0 : floorCount.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
        result = prime * result + (readyHouse ? 1231 : 1237);
        result = prime * result + ((sold == null) ? 0 : sold.hashCode());
        result = prime * result + (soldOut ? 1231 : 1237);
        result = prime * result + ((stage == null) ? 0 : stage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Building other = (Building) obj;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (buildingNumber == null) {
            if (other.buildingNumber != null) return false;
        } else if (!buildingNumber.equals(other.buildingNumber)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (finishDate == null) {
            if (other.finishDate != null) return false;
        } else if (!finishDate.equals(other.finishDate)) return false;
        if (floorCount == null) {
            if (other.floorCount != null) return false;
        } else if (!floorCount.equals(other.floorCount)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (orientation == null) {
            if (other.orientation != null) return false;
        } else if (!orientation.equals(other.orientation)) return false;
        if (readyHouse != other.readyHouse) return false;
        if (sold == null) {
            if (other.sold != null) return false;
        } else if (!sold.equals(other.sold)) return false;
        if (soldOut != other.soldOut) return false;
        if (stage == null) {
            if (other.stage != null) return false;
        } else if (!stage.equals(other.stage)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Building [id=" + id + ", bid=" + bid + ", stage=" + stage + ", buildingNumber=" + buildingNumber + ", description=" + description
               + ", finishDate=" + finishDate + ", floorCount=" + floorCount + ", orientation=" + orientation + ", readyHouse=" + readyHouse + ", sold=" + sold
               + ", soldOut=" + soldOut + ", modelModification=" + modelModification + "]";
    }

}
