package com.befun.domain.profile;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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

    @Column(name = "FIRST_NAME", length = 255)
    private String firstName;

    @Column(name = "LAST_NAME", length = 255)
    private String lastName;

    @Column(name = "MIDDLE_NAME", length = 255)
    private String middleName;

    @Column(name = "MOBILE_NUMBER", length = 255)
    private String mobileNumber;

    @Column(name = "HOME_PHONE", length = 255)
    private String homePhone;

    @Column(name = "EMPLOYEE_NUMBER", length = 255)
    private String employeeNumber;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
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
        result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Profile other = (Profile) obj;
        if (employeeNumber == null) {
            if (other.employeeNumber != null) return false;
        } else if (!employeeNumber.equals(other.employeeNumber)) return false;
        if (firstName == null) {
            if (other.firstName != null) return false;
        } else if (!firstName.equals(other.firstName)) return false;
        if (homePhone == null) {
            if (other.homePhone != null) return false;
        } else if (!homePhone.equals(other.homePhone)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (lastName == null) {
            if (other.lastName != null) return false;
        } else if (!lastName.equals(other.lastName)) return false;
        if (middleName == null) {
            if (other.middleName != null) return false;
        } else if (!middleName.equals(other.middleName)) return false;
        if (mobileNumber == null) {
            if (other.mobileNumber != null) return false;
        } else if (!mobileNumber.equals(other.mobileNumber)) return false;
        if (password == null) {
            if (other.password != null) return false;
        } else if (!password.equals(other.password)) return false;
        if (username == null) {
            if (other.username != null) return false;
        } else if (!username.equals(other.username)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profile [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
               + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", homePhone=" + homePhone + ", employeeNumber=" + employeeNumber + "]";
    }

}
