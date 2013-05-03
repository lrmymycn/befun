package com.befun.domain.poi;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.befun.domain.BaseEstateModel;
import com.befun.domain.estate.ModelModification;

public class BasePOI implements BaseEstateModel<Long> {

    private static final long serialVersionUID = 7589663530204485664L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "apartmentGenerator")
    private Long id;

    @Embedded
    private ModelModification modelModification;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public ModelModification getModelModification() {
        return null;
    }

    @Override
    public void setModelModification(ModelModification modelModification) {

    }

}
