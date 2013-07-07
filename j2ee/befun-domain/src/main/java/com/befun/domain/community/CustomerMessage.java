package com.befun.domain.community;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.befun.domain.BaseModel;

@Entity
@Table(name = "CUSTOMER_MESSAGE")
@TableGenerator(name = "customerMessageGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "customerMessage", allocationSize = 1)
public class CustomerMessage implements BaseModel<Long> {

    private static final long serialVersionUID = -105903130772344469L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customerMessageGenerator")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CUSTOMER_NAME", length = 255)
    private String customerName;

    @Column(name = "CUSTOMER_EMAIL", length = 255)
    private String customerEmail;

    @Column(name = "CUSTOMER_MOBILE", length = 20)
    private String customerMobile;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Column(name = "FLOORPLAN_ID")
    private Long floorplanId;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "PROCESS_DATE")
    private Date processDate;

    @Column(name = "PROCESSED")
    private boolean processed = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getFloorplanId() {
        return floorplanId;
    }

    public void setFloorplanId(Long floorplanId) {
        this.floorplanId = floorplanId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
        result = prime * result + ((customerMobile == null) ? 0 : customerMobile.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((floorplanId == null) ? 0 : floorplanId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((processDate == null) ? 0 : processDate.hashCode());
        result = prime * result + (processed ? 1231 : 1237);
        result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CustomerMessage other = (CustomerMessage) obj;
        if (content == null) {
            if (other.content != null) return false;
        } else if (!content.equals(other.content)) return false;
        if (creationDate == null) {
            if (other.creationDate != null) return false;
        } else if (!creationDate.equals(other.creationDate)) return false;
        if (customerEmail == null) {
            if (other.customerEmail != null) return false;
        } else if (!customerEmail.equals(other.customerEmail)) return false;
        if (customerMobile == null) {
            if (other.customerMobile != null) return false;
        } else if (!customerMobile.equals(other.customerMobile)) return false;
        if (customerName == null) {
            if (other.customerName != null) return false;
        } else if (!customerName.equals(other.customerName)) return false;
        if (floorplanId == null) {
            if (other.floorplanId != null) return false;
        } else if (!floorplanId.equals(other.floorplanId)) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (processDate == null) {
            if (other.processDate != null) return false;
        } else if (!processDate.equals(other.processDate)) return false;
        if (processed != other.processed) return false;
        if (projectId == null) {
            if (other.projectId != null) return false;
        } else if (!projectId.equals(other.projectId)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerMessage [id=" + id + ", content=" + content + ", customerName=" + customerName + ", customerEmail=" + customerEmail
               + ", customerMobile=" + customerMobile + ", projectId=" + projectId + ", floorplanId=" + floorplanId + ", creationDate=" + creationDate
               + ", processDate=" + processDate + ", processed=" + processed + "]";
    }

}
