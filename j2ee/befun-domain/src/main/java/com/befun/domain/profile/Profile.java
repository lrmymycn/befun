package com.befun.domain.profile;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.befun.domain.BaseModel;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PROFILE")
@TableGenerator(name = "profileGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "profile", allocationSize = 1)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Profile")
public class Profile implements BaseModel<Long> {

    private static final long serialVersionUID = -1108441860005157959L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "profileGenerator")
    private Long id;

    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name = "PASSWORD", length = 255)
    private String password;

    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "SURNAME", length = 45)
    private String surname;

    @Column(name = "GIVEN_NAME", length = 45)
    private String givenName;

    @Column(name = "PREFERRED_NAME", length = 45)
    private String preferredName;

    @Column(name = "MOBILE_NUMBER", length = 45)
    private String mobileNumber;

    @Column(name = "MOBILE_NUMBER1", length = 45)
    private String mobileNumber1;

    @Column(name = "HOME_PHONE", length = 45)
    private String homePhone;

    @Column(name = "HOME_ADDRESS", length = 200)
    private String homeAddress;

    @Column(name = "HOME_POSTCODE", length = 20)
    private String homePostcode;

    @Column(name = "MAIL_ADDRESS", length = 200)
    private String mailAddress;

    @Column(name = "MAIL_POSTCODE", length = 20)
    private String mailPostcode;

    @Column(name = "EMAIL", length = 200)
    private String email;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<ProfileRole> profileRoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber1() {
        return mobileNumber1;
    }

    public void setMobileNumber1(String mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomePostcode() {
        return homePostcode;
    }

    public void setHomePostcode(String homePostcode) {
        this.homePostcode = homePostcode;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailPostcode() {
        return mailPostcode;
    }

    public void setMailPostcode(String mailPostcode) {
        this.mailPostcode = mailPostcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProfileRole> getProfileRoles() {
        return profileRoles;
    }

    public void setProfileRoles(Set<ProfileRole> profileRoles) {
        this.profileRoles = profileRoles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
        result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
        result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
        result = prime * result + ((homePostcode == null) ? 0 : homePostcode.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((mailAddress == null) ? 0 : mailAddress.hashCode());
        result = prime * result + ((mailPostcode == null) ? 0 : mailPostcode.hashCode());
        result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
        result = prime * result + ((mobileNumber1 == null) ? 0 : mobileNumber1.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((preferredName == null) ? 0 : preferredName.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Profile other = (Profile) obj;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (email == null) {
            if (other.email != null) return false;
        } else if (!email.equals(other.email)) return false;
        if (gender != other.gender) return false;
        if (givenName == null) {
            if (other.givenName != null) return false;
        } else if (!givenName.equals(other.givenName)) return false;
        if (homeAddress == null) {
            if (other.homeAddress != null) return false;
        } else if (!homeAddress.equals(other.homeAddress)) return false;
        if (homePhone == null) {
            if (other.homePhone != null) return false;
        } else if (!homePhone.equals(other.homePhone)) return false;
        if (homePostcode == null) {
            if (other.homePostcode != null) return false;
        } else if (!homePostcode.equals(other.homePostcode)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (mailAddress == null) {
            if (other.mailAddress != null) return false;
        } else if (!mailAddress.equals(other.mailAddress)) return false;
        if (mailPostcode == null) {
            if (other.mailPostcode != null) return false;
        } else if (!mailPostcode.equals(other.mailPostcode)) return false;
        if (mobileNumber == null) {
            if (other.mobileNumber != null) return false;
        } else if (!mobileNumber.equals(other.mobileNumber)) return false;
        if (mobileNumber1 == null) {
            if (other.mobileNumber1 != null) return false;
        } else if (!mobileNumber1.equals(other.mobileNumber1)) return false;
        if (password == null) {
            if (other.password != null) return false;
        } else if (!password.equals(other.password)) return false;
        if (preferredName == null) {
            if (other.preferredName != null) return false;
        } else if (!preferredName.equals(other.preferredName)) return false;
        if (surname == null) {
            if (other.surname != null) return false;
        } else if (!surname.equals(other.surname)) return false;
        if (username == null) {
            if (other.username != null) return false;
        } else if (!username.equals(other.username)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender + ", surname=" + surname + ", givenName="
               + givenName + ", preferredName=" + preferredName + ", mobileNumber=" + mobileNumber + ", mobileNumber1=" + mobileNumber1 + ", homePhone="
               + homePhone + ", homeAddress=" + homeAddress + ", homePostcode=" + homePostcode + ", mailAddress=" + mailAddress + ", mailPostcode="
               + mailPostcode + ", email=" + email + ", description=" + description + "]";
    }

}
