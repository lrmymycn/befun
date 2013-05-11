package com.befun.web.view;

import java.util.ArrayList;
import java.util.List;

import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.FloorplanType;
import com.befun.domain.estate.Media;

public class FloorplanView extends BaseEasteView<Floorplan> {

    private static final long serialVersionUID = -8975615351491500648L;

    private List<ApartmentView> apartments = new ArrayList<ApartmentView>();

    private String projectName;

    private String stageName;

    private String buildingNum;

    private Long buildingId;

    private Long publicPictureId;

    private Long salePictureId;

    //
    private Media publicPicture;

    private Media salePicture;

    private String description;

    private FloorplanType type;

    private boolean split;

    private boolean studio;

    private Short bedRoomCount;

    private Short bathroomCount;

    private Short studyroomCount;

    private Short openBaclonyCount;

    private Short enclosedBaclonyCount;

    private Short courtyardCount;

    private Boolean orientationEast;

    private Boolean orientationSouth;

    private Boolean orientationWest;

    private Boolean orientationNorth;

    private Integer minPrice;

    private Integer maxPrice;

    private Integer avgPricePerSQM;

    private Double internalSize;

    private Double externalSize;

    private Double totalSize;

    private Double landSize;

    private Integer sold;

    private boolean soldOut;

    public FloorplanView() {
        super();
    }

    public FloorplanView(Floorplan model) {
        super(model);
    }

    @Override
    public Floorplan getModel() {
        return this.model;
    }

    public void setApartments(List<ApartmentView> apartments) {
        this.apartments = apartments;
    }

    public List<ApartmentView> getApartments() {
        return apartments;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }
    //

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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getPublicPictureId() {
        return publicPictureId;
    }

    public void setPublicPictureId(Long publicPictureId) {
        this.publicPictureId = publicPictureId;
    }

    public Long getSalePictureId() {
        return salePictureId;
    }

    public void setSalePictureId(Long salePictureId) {
        this.salePictureId = salePictureId;
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

    public Integer getAvgPricePerSQM() {
        return avgPricePerSQM;
    }

    public void setAvgPricePerSQM(Integer avgPricePerSQM) {
        this.avgPricePerSQM = avgPricePerSQM;
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

    @Override
    public String toString() {
        return "FloorplanView [projectName=" + projectName + ", stateName=" + stageName + ", buildingNum=" + buildingNum + ", buildingId=" + buildingId
               + ", publicPictureId=" + publicPictureId + ", salePictureId=" + salePictureId + ", publicPicture=" + publicPicture + ", salePicture="
               + salePicture + ", description=" + description + ", type=" + type + ", split=" + split + ", studio=" + studio + ", bedRoomCount=" + bedRoomCount
               + ", bathroomCount=" + bathroomCount + ", studyroomCount=" + studyroomCount + ", openBaclonyCount=" + openBaclonyCount
               + ", enclosedBaclonyCount=" + enclosedBaclonyCount + ", courtyardCount=" + courtyardCount + ", orientationEast=" + orientationEast
               + ", orientationSouth=" + orientationSouth + ", orientationWest=" + orientationWest + ", orientationNorth=" + orientationNorth + ", minPrice="
               + minPrice + ", maxPrice=" + maxPrice + ", avgPricePerSQM=" + avgPricePerSQM + ", internalSize=" + internalSize + ", externalSize="
               + externalSize + ", totalSize=" + totalSize + ", landSize=" + landSize + ", sold=" + sold + ", soldOut=" + soldOut + ", toString()="
               + super.toString() + "]";
    }

}
