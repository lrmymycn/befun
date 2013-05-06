package com.befun.domain.profile;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "CLIENT")
@DiscriminatorValue("Client")
@PrimaryKeyJoinColumn(name = "ID")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "profile")
public class Client extends Profile {

    private static final long serialVersionUID = 8457225248069897238L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "CURRENT_EMPLOYEE")
    private Employee currentEmployee;

    @Column(name = "TITLE")
    @Enumerated(EnumType.ORDINAL)
    private ClientTitle title;

    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private ClientStatus status;

    @Column(name = "PURCHASE_TYPE_FIRST")
    private Boolean purchaseTypeFirst;

    @Column(name = "PURCHASE_TYPE_OWNER")
    private Boolean purchaseTypeOwner;

    @Column(name = "PURCHASE_TYPE_INVERSTOR")
    private Boolean purchaseTypeInverstor;

    @Column(name = "PURCHASE_TYPE_STUDENT")
    private Boolean purchaseTypeStudent;

    @Column(name = "PURCHASE_TYPE_OTHER")
    private Boolean purchaseTypeOther;

    @Column(name = "PURCHASE_TYPE_1")
    private Boolean purchaseType1;

    @Column(name = "PURCHASE_TYPE_2")
    private Boolean purchaseType2;

    @Column(name = "PURCHASE_TYPE_3")
    private Boolean purchaseType3;

    @Column(name = "PURCHASE_TYPE_4")
    private Boolean purchaseType4;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "CLIENT_PREFERENCE_ID")
    private ClientPreference preference;

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public ClientTitle getTitle() {
        return title;
    }

    public void setTitle(ClientTitle title) {
        this.title = title;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public Boolean getPurchaseTypeFirst() {
        return purchaseTypeFirst;
    }

    public void setPurchaseTypeFirst(Boolean purchaseTypeFirst) {
        this.purchaseTypeFirst = purchaseTypeFirst;
    }

    public Boolean getPurchaseTypeOwner() {
        return purchaseTypeOwner;
    }

    public void setPurchaseTypeOwner(Boolean purchaseTypeOwner) {
        this.purchaseTypeOwner = purchaseTypeOwner;
    }

    public Boolean getPurchaseTypeInverstor() {
        return purchaseTypeInverstor;
    }

    public void setPurchaseTypeInverstor(Boolean purchaseTypeInverstor) {
        this.purchaseTypeInverstor = purchaseTypeInverstor;
    }

    public Boolean getPurchaseTypeStudent() {
        return purchaseTypeStudent;
    }

    public void setPurchaseTypeStudent(Boolean purchaseTypeStudent) {
        this.purchaseTypeStudent = purchaseTypeStudent;
    }

    public Boolean getPurchaseTypeOther() {
        return purchaseTypeOther;
    }

    public void setPurchaseTypeOther(Boolean purchaseTypeOther) {
        this.purchaseTypeOther = purchaseTypeOther;
    }

    public Boolean getPurchaseType1() {
        return purchaseType1;
    }

    public void setPurchaseType1(Boolean purchaseType1) {
        this.purchaseType1 = purchaseType1;
    }

    public Boolean getPurchaseType2() {
        return purchaseType2;
    }

    public void setPurchaseType2(Boolean purchaseType2) {
        this.purchaseType2 = purchaseType2;
    }

    public Boolean getPurchaseType3() {
        return purchaseType3;
    }

    public void setPurchaseType3(Boolean purchaseType3) {
        this.purchaseType3 = purchaseType3;
    }

    public Boolean getPurchaseType4() {
        return purchaseType4;
    }

    public void setPurchaseType4(Boolean purchaseType4) {
        this.purchaseType4 = purchaseType4;
    }

    public ClientPreference getPreference() {
        return preference;
    }

    public void setPreference(ClientPreference preference) {
        this.preference = preference;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((currentEmployee == null) ? 0 : currentEmployee.hashCode());
        result = prime * result + ((purchaseType1 == null) ? 0 : purchaseType1.hashCode());
        result = prime * result + ((purchaseType2 == null) ? 0 : purchaseType2.hashCode());
        result = prime * result + ((purchaseType3 == null) ? 0 : purchaseType3.hashCode());
        result = prime * result + ((purchaseType4 == null) ? 0 : purchaseType4.hashCode());
        result = prime * result + ((purchaseTypeFirst == null) ? 0 : purchaseTypeFirst.hashCode());
        result = prime * result + ((purchaseTypeInverstor == null) ? 0 : purchaseTypeInverstor.hashCode());
        result = prime * result + ((purchaseTypeOther == null) ? 0 : purchaseTypeOther.hashCode());
        result = prime * result + ((purchaseTypeOwner == null) ? 0 : purchaseTypeOwner.hashCode());
        result = prime * result + ((purchaseTypeStudent == null) ? 0 : purchaseTypeStudent.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        if (currentEmployee == null) {
            if (other.currentEmployee != null) return false;
        } else if (!currentEmployee.equals(other.currentEmployee)) return false;
        if (purchaseType1 == null) {
            if (other.purchaseType1 != null) return false;
        } else if (!purchaseType1.equals(other.purchaseType1)) return false;
        if (purchaseType2 == null) {
            if (other.purchaseType2 != null) return false;
        } else if (!purchaseType2.equals(other.purchaseType2)) return false;
        if (purchaseType3 == null) {
            if (other.purchaseType3 != null) return false;
        } else if (!purchaseType3.equals(other.purchaseType3)) return false;
        if (purchaseType4 == null) {
            if (other.purchaseType4 != null) return false;
        } else if (!purchaseType4.equals(other.purchaseType4)) return false;
        if (purchaseTypeFirst == null) {
            if (other.purchaseTypeFirst != null) return false;
        } else if (!purchaseTypeFirst.equals(other.purchaseTypeFirst)) return false;
        if (purchaseTypeInverstor == null) {
            if (other.purchaseTypeInverstor != null) return false;
        } else if (!purchaseTypeInverstor.equals(other.purchaseTypeInverstor)) return false;
        if (purchaseTypeOther == null) {
            if (other.purchaseTypeOther != null) return false;
        } else if (!purchaseTypeOther.equals(other.purchaseTypeOther)) return false;
        if (purchaseTypeOwner == null) {
            if (other.purchaseTypeOwner != null) return false;
        } else if (!purchaseTypeOwner.equals(other.purchaseTypeOwner)) return false;
        if (purchaseTypeStudent == null) {
            if (other.purchaseTypeStudent != null) return false;
        } else if (!purchaseTypeStudent.equals(other.purchaseTypeStudent)) return false;
        if (status != other.status) return false;
        if (title != other.title) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [currentEmployee=" + currentEmployee + ", title=" + title + ", status=" + status + ", purchaseTypeFirst=" + purchaseTypeFirst
               + ", purchaseTypeOwner=" + purchaseTypeOwner + ", purchaseTypeInverstor=" + purchaseTypeInverstor + ", purchaseTypeStudent="
               + purchaseTypeStudent + ", purchaseTypeOther=" + purchaseTypeOther + ", purchaseType1=" + purchaseType1 + ", purchaseType2=" + purchaseType2
               + ", purchaseType3=" + purchaseType3 + ", purchaseType4=" + purchaseType4 + ", toString()=" + super.toString() + "]";
    }

}
