package com.befun.domain.profile;

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

import com.befun.domain.ModificationModel;
import com.befun.domain.Modification;

@Entity
@Table(name = "APARTMENT_INTEREST_LIST_ITEM")
@TableGenerator(name = "apartmentInterestListItemGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "apartmentInterestListItem", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "apartmentInterestListItem")
public class ApartmentInterestListItem implements ModificationModel<Long> {

    private static final long serialVersionUID = 2171356704749634553L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "apartmentInterestListItemGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "INTEREST_LIST_ID")
    private InterestList interestList;

    @Column(name = "APARTMENT_ID")
    private Long propertyId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private Modification modification = Modification.createDefault();

    public ApartmentInterestListItem() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public InterestList getInterestList() {
        return interestList;
    }

    public void setInterestList(InterestList interestList) {
        this.interestList = interestList;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Modification getModification() {
        return modification;
    }

    public void setModification(Modification modification) {
        this.modification = modification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((propertyId == null) ? 0 : propertyId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ApartmentInterestListItem other = (ApartmentInterestListItem) obj;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (propertyId == null) {
            if (other.propertyId != null) return false;
        } else if (!propertyId.equals(other.propertyId)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "ApartmentInterestListItem [id=" + id + ", propertyId=" + propertyId + ", description=" + description + "]";
    }

}
