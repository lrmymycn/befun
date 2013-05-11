package com.befun.web.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.befun.domain.estate.Media;
import com.befun.domain.estate.Project;

public class ProjectView extends BaseEasteView<Project> {

    private static final long serialVersionUID = -2928670235531216770L;

    private List<FloorplanView> floorplans = new ArrayList<FloorplanView>();

    private Long areaId;

    private Long suburbId;

    private String suburbName;

    private Long pictureId;

    private Long logoId;

    //
    private Media picture;

    private Media logo;

    private String name;

    private String block;

    private String siteUrl;

    private String description;

    private String features;

    private String finishSchema;

    private String developer;

    private String address;

    private String postcode;

    private boolean swimmingPool;

    private boolean gym;

    private boolean sauna;

    private boolean tennisCourt;

    private boolean playRoom;

    private boolean funcRoom;

    private boolean theatreCinema;

    private boolean musicRoom;

    private boolean library;

    private boolean bbq;

    private boolean visitorParking;

    private boolean kidsPlayGround;

    private boolean skyGarden;

    private boolean landScaping;

    private boolean recreationPlace;

    private boolean carWashBay;

    private boolean others;

    private Date finishDate;

    private Double distanceToCity;

    private Integer sold;

    private boolean soldOut;

    private Double longitude;

    private Double latitude;

    private List<Media> medias;

    public ProjectView() {
        super();
    }

    public ProjectView(Project model) {
        super(model);
    }

    public List<FloorplanView> getFloorplans() {
        return floorplans;
    }

    //

    public Long getAreaId() {
        return areaId;
    }

    public Media getPicture() {
        return picture;
    }

    public void setPicture(Media picture) {
        this.picture = picture;
    }

    public Media getLogo() {
        return logo;
    }

    public void setLogo(Media logo) {
        this.logo = logo;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getSuburbId() {
        return suburbId;
    }

    public void setSuburbId(Long suburbId) {
        this.suburbId = suburbId;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public Long getLogoId() {
        return logoId;
    }

    public void setLogoId(Long logoId) {
        this.logoId = logoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getFinishSchema() {
        return finishSchema;
    }

    public void setFinishSchema(String finishSchema) {
        this.finishSchema = finishSchema;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }

    public boolean isTennisCourt() {
        return tennisCourt;
    }

    public void setTennisCourt(boolean tennisCourt) {
        this.tennisCourt = tennisCourt;
    }

    public boolean isPlayRoom() {
        return playRoom;
    }

    public void setPlayRoom(boolean playRoom) {
        this.playRoom = playRoom;
    }

    public boolean isFuncRoom() {
        return funcRoom;
    }

    public void setFuncRoom(boolean funcRoom) {
        this.funcRoom = funcRoom;
    }

    public boolean isTheatreCinema() {
        return theatreCinema;
    }

    public void setTheatreCinema(boolean theatreCinema) {
        this.theatreCinema = theatreCinema;
    }

    public boolean isMusicRoom() {
        return musicRoom;
    }

    public void setMusicRoom(boolean musicRoom) {
        this.musicRoom = musicRoom;
    }

    public boolean isLibrary() {
        return library;
    }

    public void setLibrary(boolean library) {
        this.library = library;
    }

    public boolean isBbq() {
        return bbq;
    }

    public void setBbq(boolean bbq) {
        this.bbq = bbq;
    }

    public boolean isVisitorParking() {
        return visitorParking;
    }

    public void setVisitorParking(boolean visitorParking) {
        this.visitorParking = visitorParking;
    }

    public boolean isKidsPlayGround() {
        return kidsPlayGround;
    }

    public void setKidsPlayGround(boolean kidsPlayGround) {
        this.kidsPlayGround = kidsPlayGround;
    }

    public boolean isSkyGarden() {
        return skyGarden;
    }

    public void setSkyGarden(boolean skyGarden) {
        this.skyGarden = skyGarden;
    }

    public boolean isLandScaping() {
        return landScaping;
    }

    public void setLandScaping(boolean landScaping) {
        this.landScaping = landScaping;
    }

    public boolean isRecreationPlace() {
        return recreationPlace;
    }

    public void setRecreationPlace(boolean recreationPlace) {
        this.recreationPlace = recreationPlace;
    }

    public boolean isCarWashBay() {
        return carWashBay;
    }

    public void setCarWashBay(boolean carWashBay) {
        this.carWashBay = carWashBay;
    }

    public boolean isOthers() {
        return others;
    }

    public void setOthers(boolean others) {
        this.others = others;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Double getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(Double distanceToCity) {
        this.distanceToCity = distanceToCity;
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

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

}
