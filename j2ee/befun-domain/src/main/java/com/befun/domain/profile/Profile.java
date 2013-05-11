package com.befun.domain.profile;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
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

import com.befun.domain.ModificationModel;
import com.befun.domain.Modification;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PROFILE")
@TableGenerator(name = "profileGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "profile", allocationSize = 1)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Profile")
public class Profile implements ModificationModel<Long> {

    private static final long serialVersionUID = -1108441860005157959L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "profileGenerator")
    private Long id;

    @Column(name = "TYPE", nullable = false)
    private ProfileType type = ProfileType.GENERAL;

    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name = "PASSWORD", length = 255)
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled = true;

    @Column(name = "EXPIRED")
    private boolean expired = false;

    @Column(name = "CREDENTIALS_EXPIRED")
    private boolean credentialsExpired = false;

    @Column(name = "LOCKED")
    private boolean locked = false;

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

    @Column(name = "OTHER_NUMBER", length = 45)
    private String otherNumber;

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

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<ProfileDepartment> profileDepartments;

    @Embedded
    private Modification modification = Modification.createDefault();

    public Profile(){
        super();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileType getType() {
        return type;
    }

    protected void setType(ProfileType type) {
        this.type = type;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getOtherNumber() {
        return otherNumber;
    }

    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
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

    public Set<ProfileDepartment> getProfileDepartments() {
        return profileDepartments;
    }

    public void setProfileDepartments(Set<ProfileDepartment> profileDepartments) {
        this.profileDepartments = profileDepartments;
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
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
        result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
        result = prime * result + ((homePostcode == null) ? 0 : homePostcode.hashCode());
        result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
        result = prime * result + ((mobileNumber1 == null) ? 0 : mobileNumber1.hashCode());
        result = prime * result + ((otherNumber == null) ? 0 : otherNumber.hashCode());
        result = prime * result + ((preferredName == null) ? 0 : preferredName.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Profile other = (Profile) obj;
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
        if (homePostcode == null) {
            if (other.homePostcode != null) return false;
        } else if (!homePostcode.equals(other.homePostcode)) return false;
        if (mobileNumber == null) {
            if (other.mobileNumber != null) return false;
        } else if (!mobileNumber.equals(other.mobileNumber)) return false;
        if (mobileNumber1 == null) {
            if (other.mobileNumber1 != null) return false;
        } else if (!mobileNumber1.equals(other.mobileNumber1)) return false;
        if (otherNumber == null) {
            if (other.otherNumber != null) return false;
        } else if (!otherNumber.equals(other.otherNumber)) return false;
        if (preferredName == null) {
            if (other.preferredName != null) return false;
        } else if (!preferredName.equals(other.preferredName)) return false;
        if (surname == null) {
            if (other.surname != null) return false;
        } else if (!surname.equals(other.surname)) return false;
        if (type == null) {
            if (other.type != null) return false;
        } else if (!type.equals(other.type)) return false;
        if (username == null) {
            if (other.username != null) return false;
        } else if (!username.equals(other.username)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", type=" + type + ", username=" + username + ", password=" + password + ", gender=" + gender + ", surname=" + surname
               + ", givenName=" + givenName + ", preferredName=" + preferredName + ", mobileNumber=" + mobileNumber + ", mobileNumber1=" + mobileNumber1
               + ", otherNumber=" + otherNumber + ", homePhone=" + homePhone + ", homeAddress=" + homeAddress + ", homePostcode=" + homePostcode
               + ", mailAddress=" + mailAddress + ", mailPostcode=" + mailPostcode + ", email=" + email + ", description=" + description + "]";
    }

}
