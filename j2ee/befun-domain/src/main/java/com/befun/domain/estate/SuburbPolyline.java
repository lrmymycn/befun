package com.befun.domain.estate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
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

import com.befun.domain.BaseModel;

@Entity
@Table(name = "SUBURB_POLYLINE")
@TableGenerator(name = "suburbPolylineGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "suburbPolyline", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="geography")
public class SuburbPolyline implements BaseModel<Long> {

    private static final long serialVersionUID = 4608233353150580737L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "suburbPolylineGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "SUBURB_ID")
    private Suburb suburb;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "seq_num")
    private Integer seqNum;

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

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((seqNum == null) ? 0 : seqNum.hashCode());
        result = prime * result + ((suburb == null) ? 0 : suburb.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SuburbPolyline other = (SuburbPolyline) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (latitude == null) {
            if (other.latitude != null) return false;
        } else if (!latitude.equals(other.latitude)) return false;
        if (longitude == null) {
            if (other.longitude != null) return false;
        } else if (!longitude.equals(other.longitude)) return false;
        if (seqNum == null) {
            if (other.seqNum != null) return false;
        } else if (!seqNum.equals(other.seqNum)) return false;
        if (suburb == null) {
            if (other.suburb != null) return false;
        } else if (!suburb.equals(other.suburb)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "SuburbPolyline [id=" + id + ", suburb=" + suburb + ", longitude=" + longitude + ", latitude=" + latitude + ", seqNum=" + seqNum + "]";
    }

}
