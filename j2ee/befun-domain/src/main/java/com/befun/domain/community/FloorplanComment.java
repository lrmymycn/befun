package com.befun.domain.community;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
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
@Table(name = "FLOORPLAN_COMMENT")
@TableGenerator(name = "floorplanCommentGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "floorplanComment", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "floorplanComment")
public class FloorplanComment implements BaseModel<Long> {

    private static final long serialVersionUID = -3535513754010362552L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "floorplanCommentGenerator")
    private Long id;

    @Column(name = "FLOORPLAN_ID")
    private Long floorplanId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(referencedColumnName = "id", name = "COMMENT_ID")
    private Comment comment;

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        id = pId;
    }

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment pComment) {
        comment = pComment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((floorplanId == null) ? 0 : floorplanId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        FloorplanComment other = (FloorplanComment) obj;
        if (comment == null) {
            if (other.comment != null) return false;
        } else if (!comment.equals(other.comment)) return false;
        if (floorplanId == null) {
            if (other.floorplanId != null) return false;
        } else if (!floorplanId.equals(other.floorplanId)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "FloorplanComment [id=" + id + ", floorplanId=" + floorplanId + ", comment=" + comment + "]";
    }

}
