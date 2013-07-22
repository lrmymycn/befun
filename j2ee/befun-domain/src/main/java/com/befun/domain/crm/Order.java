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
@Table(name = "ESTATE_ORDER")
@TableGenerator(name = "estateOrderGenerator", table = "ID_GENERATOR", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "order", allocationSize = 1)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "order")
public class Order implements BaseModel<Long> {

    private static final long serialVersionUID = -8887027634719864285L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "estateOrderGenerator")
    private Long id;

    private Employee employee;

    private Client client;

    private String title;

    private String content;

    private Date logDate;

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setId(Long id) {
        // TODO Auto-generated method stub

    }

}
