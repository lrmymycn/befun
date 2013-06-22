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
@Table(name = "PROJECT")
@TableGenerator(name = "projectGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "project", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "project")
public class Project implements BaseEstateModel<Long> {

    private static final long serialVersionUID = 7873456988953911225L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "projectGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "SUBURB_ID")
    private Suburb suburb;

    @Column(name = "BID", length = 255)
    private String bid;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "BLOCK", length = 255)
    private String block;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "PICTURE_ID")
    private Media picture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "LOGO_ID")
    private Media logo;

    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRICE_RANGE")
    private String priceRange;

    @Column(name = "SITE_URL", length = 500)
    private String siteUrl;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FEATURES")
    private String features;

    @Column(name = "FINISH_SCHEMA")
    private String finishSchema;

    @Column(name = "DEVELOPER")
    private String developer;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POSTCODE")
    private String postcode;

    @Column(name = "SWIMMING_POOL")
    private boolean swimmingPool;

    @Column(name = "GYM")
    private boolean gym;

    @Column(name = "SAUNA")
    private boolean sauna;

    @Column(name = "TENNIS_COURT")
    private boolean tennisCourt;

    @Column(name = "PLAY_ROOM")
    private boolean playRoom;

    @Column(name = "FUNC_ROOM")
    private boolean funcRoom;

    @Column(name = "THEATRE_CINEMA")
    private boolean theatreCinema;

    @Column(name = "MUSIC_ROOM")
    private boolean musicRoom;

    @Column(name = "LIBRARY")
    private boolean library;

    @Column(name = "BBQ")
    private boolean bbq;

    @Column(name = "VISITOR_PARKING")
    private boolean visitorParking;

    @Column(name = "KIDS_PLAY_GROUND")
    private boolean kidsPlayGround;

    @Column(name = "SKY_GARDEN")
    private boolean skyGarden;

    @Column(name = "LAND_SCAPING")
    private boolean landScaping;

    @Column(name = "RECREATION_PLACE")
    private boolean recreationPlace;

    @Column(name = "CAR_WASH_BAY")
    private boolean carWashBay;

    @Column(name = "OTHERS")
    private boolean others;

    @Column(name = "FINISH_DATE")
    private Date finishDate;

    @Column(name = "DISTANCE_TO_CITY")
    private Double distanceToCity;

    @Column(name = "SOLD")
    private Integer sold;

    @Column(name = "SOLD_OUT")
    private boolean soldOut;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Stage> stages;

    @Embedded
    private ModelModification modelModification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Suburb getSuburb() {
        return suburb;
    }

    public void setSuburb(Suburb suburb) {
        this.suburb = suburb;
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

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
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

    public Set<Stage> getStages() {
        return stages;
    }

    public void setStages(Set<Stage> stages) {
        this.stages = stages;
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
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + (bbq ? 1231 : 1237);
        result = prime * result + ((bid == null) ? 0 : bid.hashCode());
        result = prime * result + ((block == null) ? 0 : block.hashCode());
        result = prime * result + (carWashBay ? 1231 : 1237);
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((developer == null) ? 0 : developer.hashCode());
        result = prime * result + ((distanceToCity == null) ? 0 : distanceToCity.hashCode());
        result = prime * result + ((features == null) ? 0 : features.hashCode());
        result = prime * result + ((finishDate == null) ? 0 : finishDate.hashCode());
        result = prime * result + ((finishSchema == null) ? 0 : finishSchema.hashCode());
        result = prime * result + (funcRoom ? 1231 : 1237);
        result = prime * result + (gym ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (kidsPlayGround ? 1231 : 1237);
        result = prime * result + (landScaping ? 1231 : 1237);
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + (library ? 1231 : 1237);
        result = prime * result + ((logo == null) ? 0 : logo.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((modelModification == null) ? 0 : modelModification.hashCode());
        result = prime * result + (musicRoom ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (others ? 1231 : 1237);
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result + (playRoom ? 1231 : 1237);
        result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
        result = prime * result + (recreationPlace ? 1231 : 1237);
        result = prime * result + (sauna ? 1231 : 1237);
        result = prime * result + ((siteUrl == null) ? 0 : siteUrl.hashCode());
        result = prime * result + (skyGarden ? 1231 : 1237);
        result = prime * result + ((sold == null) ? 0 : sold.hashCode());
        result = prime * result + (soldOut ? 1231 : 1237);
        result = prime * result + ((suburb == null) ? 0 : suburb.hashCode());
        result = prime * result + (swimmingPool ? 1231 : 1237);
        result = prime * result + (tennisCourt ? 1231 : 1237);
        result = prime * result + (theatreCinema ? 1231 : 1237);
        result = prime * result + (visitorParking ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Project other = (Project) obj;
        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) return false;
        if (bbq != other.bbq) return false;
        if (bid == null) {
            if (other.bid != null) return false;
        } else if (!bid.equals(other.bid)) return false;
        if (block == null) {
            if (other.block != null) return false;
        } else if (!block.equals(other.block)) return false;
        if (carWashBay != other.carWashBay) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (developer == null) {
            if (other.developer != null) return false;
        } else if (!developer.equals(other.developer)) return false;
        if (distanceToCity == null) {
            if (other.distanceToCity != null) return false;
        } else if (!distanceToCity.equals(other.distanceToCity)) return false;
        if (features == null) {
            if (other.features != null) return false;
        } else if (!features.equals(other.features)) return false;
        if (finishDate == null) {
            if (other.finishDate != null) return false;
        } else if (!finishDate.equals(other.finishDate)) return false;
        if (finishSchema == null) {
            if (other.finishSchema != null) return false;
        } else if (!finishSchema.equals(other.finishSchema)) return false;
        if (funcRoom != other.funcRoom) return false;
        if (gym != other.gym) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (kidsPlayGround != other.kidsPlayGround) return false;
        if (landScaping != other.landScaping) return false;
        if (latitude == null) {
            if (other.latitude != null) return false;
        } else if (!latitude.equals(other.latitude)) return false;
        if (library != other.library) return false;
        if (logo == null) {
            if (other.logo != null) return false;
        } else if (!logo.equals(other.logo)) return false;
        if (longitude == null) {
            if (other.longitude != null) return false;
        } else if (!longitude.equals(other.longitude)) return false;
        if (modelModification == null) {
            if (other.modelModification != null) return false;
        } else if (!modelModification.equals(other.modelModification)) return false;
        if (musicRoom != other.musicRoom) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (others != other.others) return false;
        if (picture == null) {
            if (other.picture != null) return false;
        } else if (!picture.equals(other.picture)) return false;
        if (playRoom != other.playRoom) return false;
        if (postcode == null) {
            if (other.postcode != null) return false;
        } else if (!postcode.equals(other.postcode)) return false;
        if (recreationPlace != other.recreationPlace) return false;
        if (sauna != other.sauna) return false;
        if (siteUrl == null) {
            if (other.siteUrl != null) return false;
        } else if (!siteUrl.equals(other.siteUrl)) return false;
        if (skyGarden != other.skyGarden) return false;
        if (sold == null) {
            if (other.sold != null) return false;
        } else if (!sold.equals(other.sold)) return false;
        if (soldOut != other.soldOut) return false;
        if (suburb == null) {
            if (other.suburb != null) return false;
        } else if (!suburb.equals(other.suburb)) return false;
        if (swimmingPool != other.swimmingPool) return false;
        if (tennisCourt != other.tennisCourt) return false;
        if (theatreCinema != other.theatreCinema) return false;
        if (visitorParking != other.visitorParking) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", suburb=" + suburb + ", bid=" + bid + ", name=" + name + ", block=" + block + ", picture=" + picture + ", logo=" + logo
               + ", siteUrl=" + siteUrl + ", description=" + description + ", features=" + features + ", finishSchema=" + finishSchema + ", developer="
               + developer + ", address=" + address + ", postcode=" + postcode + ", swimmingPool=" + swimmingPool + ", gym=" + gym + ", sauna=" + sauna
               + ", tennisCourt=" + tennisCourt + ", playRoom=" + playRoom + ", funcRoom=" + funcRoom + ", theatreCinema=" + theatreCinema + ", musicRoom="
               + musicRoom + ", library=" + library + ", bbq=" + bbq + ", visitorParking=" + visitorParking + ", kidsPlayGround=" + kidsPlayGround
               + ", skyGarden=" + skyGarden + ", landScaping=" + landScaping + ", recreationPlace=" + recreationPlace + ", carWashBay=" + carWashBay
               + ", others=" + others + ", finishDate=" + finishDate + ", distanceToCity=" + distanceToCity + ", sold=" + sold + ", soldOut=" + soldOut
               + ", longitude=" + longitude + ", latitude=" + latitude + ", modelModification=" + modelModification + "]";
    }

}
