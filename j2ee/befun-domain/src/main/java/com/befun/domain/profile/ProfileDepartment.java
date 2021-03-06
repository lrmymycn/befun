package com.befun.domain.profile;

import java.util.Date;

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

import com.befun.domain.BaseModel;

@Entity
@Table(name = "PROFILE_DEPARTMENT")
@TableGenerator(name = "profileDepartmentGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "profileDepartment", allocationSize = 1)
public class ProfileDepartment implements BaseModel<Long> {

	private static final long serialVersionUID = 5278390492418029644L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "profileDepartmentGenerator")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", name = "PROFILE_ID")
	private Profile profile;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", name = "DEPARTMENT_ID")
	private Department department;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	public ProfileDepartment() {
        super();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileDepartment other = (ProfileDepartment) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfileDepartment [id=" + id + ", profile=" + profile
				+ ", department=" + department + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
