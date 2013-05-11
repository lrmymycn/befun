package com.befun.domain.profile;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.ModificationModel;
import com.befun.domain.Modification;

@Entity
@Table(name = "INTEREST_LIST")
@TableGenerator(name = "interestListItemGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "interestList", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "profile")
public class InterestList implements ModificationModel<Long> {

    private static final long serialVersionUID = -2254810037484271969L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "interestListItemGenerator")
    private Long id;

    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private Modification modification = Modification.createDefault();

    @OneToMany(mappedBy = "interestList", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("modification.lastModifiedDate ASC")
    private List<ApartmentInterestListItem> apartments;

    @OneToMany(mappedBy = "interestList", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("modification.lastModifiedDate ASC")
    private List<FloorplanInterestListItem> floorplans;

    @OneToMany(mappedBy = "interestList", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("modification.lastModifiedDate ASC")
    private List<ProjectInterestListItem> projects;

    @OneToMany(mappedBy = "interestList", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @OrderBy("modification.lastModifiedDate ASC")
    private List<SuburbInterestListItem> suburbs;

    public InterestList() {
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<ApartmentInterestListItem> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentInterestListItem> apartments) {
        this.apartments = apartments;
    }

    public List<FloorplanInterestListItem> getFloorplans() {
        return floorplans;
    }

    public void setFloorplans(List<FloorplanInterestListItem> floorplans) {
        this.floorplans = floorplans;
    }

    public List<ProjectInterestListItem> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectInterestListItem> projects) {
        this.projects = projects;
    }

    public List<SuburbInterestListItem> getSuburbs() {
        return suburbs;
    }

    public void setSuburbs(List<SuburbInterestListItem> suburbs) {
        this.suburbs = suburbs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        InterestList other = (InterestList) obj;
        if (clientId == null) {
            if (other.clientId != null) return false;
        } else if (!clientId.equals(other.clientId)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "InterestList [id=" + id + ", clientId=" + clientId + ", name=" + name + ", description=" + description + "]";
    }

}
