package com.befun.domain;

import java.io.Serializable;

import com.befun.domain.estate.ModelModification;

public interface BaseEstateModel<PK extends Serializable> extends BaseModel<PK> {

    public ModelModification getModelModification();

    public void setModelModification(ModelModification modelModification);

}
