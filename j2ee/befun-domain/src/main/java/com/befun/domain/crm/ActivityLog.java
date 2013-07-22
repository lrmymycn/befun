package com.befun.domain.crm;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.befun.domain.BaseModel;
import com.befun.domain.profile.Client;
import com.befun.domain.profile.Employee;

@Entity
@Table(name = "ACTIVITY_LOG")
@TableGenerator(name = "activityLogGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "activityLog", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "activityLog")
public class ActivityLog implements BaseModel<Long> {

    private static final long serialVersionUID = 8707121004189165248L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "activityLogGenerator")
    private Long id;

    private Employee employee;

    private Client client;

    private String title;

    private String content;

    private Date logDate;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

}
