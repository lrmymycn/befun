package com.befun.domain.community;

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
import com.befun.domain.estate.Apartment;

@Entity
@Table(name = "APARTMENT_COMMENT")
@TableGenerator(name = "apartmentCommentGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "apartmentComment", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="comment")
public class ApartmentComment implements BaseModel<Long> {

    private static final long serialVersionUID = -1321914916008153840L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "apartmentCommentGenerator")
    private Long              id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "APARTMENT_ID")
    private Apartment         apartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "COMMENT_ID")
    private Comment           comment;

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        id = pId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment pApartment) {
        apartment = pApartment;
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
        result = prime * result + ((apartment == null) ? 0 : apartment.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ApartmentComment other = (ApartmentComment) obj;
        if (apartment == null) {
            if (other.apartment != null) return false;
        } else if (!apartment.equals(other.apartment)) return false;
        if (comment == null) {
            if (other.comment != null) return false;
        } else if (!comment.equals(other.comment)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ApartmentComment [id=" + id + ", apartment=" + apartment + ", comment=" + comment + "]";
    }

}
