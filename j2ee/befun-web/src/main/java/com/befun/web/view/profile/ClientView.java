package com.befun.web.view.profile;

import java.util.Date;

import com.befun.domain.profile.Client;
import com.befun.domain.profile.ClientStatus;
import com.befun.domain.profile.ClientTitle;
import com.befun.domain.profile.Gender;
import com.befun.domain.profile.ProfileType;

public class ClientView extends BaseProfileView<Client> {

    private static final long serialVersionUID = 8667474061624028418L;

    private ProfileType type = ProfileType.GENERAL;

    private String username;

    private String password;

    private Gender gender;

    private String surname;

    private String givenName;

    private String preferredName;

    private String mobileNumber;

    private String otherNumber;

    private String homePhone;

    private String homeAddress;

    private String homePostcode;

    private String mailAddress;

    private String mailPostcode;

    private String email;

    private String description;

    private EmployeeView currentEmployee;

    private ClientTitle title;

    private ClientStatus status;

    private Boolean purchaseTypeFirst;

    private Boolean purchaseTypeOwner;

    private Boolean purchaseTypeInverstor;

    private Boolean purchaseTypeStudent;

    private Boolean purchaseTypeOther;

    private Date lastActiveDate;

    private ClientPreferenceView preference;

    public ClientView() {
        super();
    }

    public ClientView(Client model) {
        super(model);
    }

    @Override
    public Client getModel() {
        return this.model;
    }

    public ProfileType getType() {
        return type;
    }

    public void setType(ProfileType type) {
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

    public EmployeeView getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(EmployeeView currentEmployee) {
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

    public Date getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(Date lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }

    public ClientPreferenceView getPreference() {
        return preference;
    }

    public void setPreference(ClientPreferenceView preference) {
        this.preference = preference;
    }

}
