package com.befun.service.estate.impl;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.domain.BaseEstateModel;
import com.befun.domain.estate.ModelModification;
import com.befun.service.BaseService;
import com.befun.service.estate.BaseEstateService;

public abstract class BaseEstateServiceImpl<M extends BaseEstateModel<PK>, PK extends Serializable> extends BaseService<M, PK> implements BaseEstateService<M, PK> {

    @Override
    @Transactional
    public void enable(PK id) {
        M model = this.dao.get(id);
        model.getModelModification().setEnabled(true);
        this.dao.update(model);
    }

    @Override
    @Transactional
    public void disable(PK id) {
        M model = this.dao.get(id);
        model.getModelModification().setEnabled(false);
        this.dao.update(model);
    }

    @Override
    public PK save(M model) {
        Assert.notNull(model, "model should be not null!");
        if(model.getModelModification() == null){
            model.setModelModification(ModelModification.createDefault());
        }
        return super.save(model);
    }
    
    @Override
    public void update(M model, String[] ignoreProps) {
        Assert.notNull(model, "model should be not null!");
        Assert.notNull(model.getId());
        M exist = this.dao.get(model.getId());
        Assert.notNull(exist, model.getClass() + " with id" + model.getId() + " can not be found!");
        BeanUtils.copyProperties(model, exist, ignoreProps);
        if(exist.getModelModification() == null){
            exist.setModelModification(ModelModification.createDefault());
        }else{
            exist.getModelModification().setLastModifiedDate(new Date());
        }
        dao.update(exist);
    }
}
