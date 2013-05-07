package com.befun.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.befun.domain.ModificationModel;
import com.befun.domain.Modification;

public abstract class BaseModificationService<M extends ModificationModel<PK>, PK extends Serializable> extends BaseService<M, PK> implements
                IBaseModificationService<M, PK> {

    @Override
    public PK save(M model) {
        model.setModification(Modification.createDefault());
        return super.save(model);
    }

    @Override
    public void merge(M model) {
        if (model.getModification() == null) {
            model.setModification(Modification.createDefault());
        } else {
            model.getModification().setLastModifiedDate(new Date());
        }
        super.merge(model);
    }

    @Override
    public void update(M model, String[] ignoreProps) {
        Assert.notNull(model, "model should be not null!");
        Assert.notNull(model.getId());
        M exist = this.dao.get(model.getId());
        Assert.notNull(exist, model.getClass() + " with id" + model.getId() + " can not be found!");
        BeanUtils.copyProperties(model, exist, ignoreProps);
        if (exist.getModification() == null) {
            exist.setModification(Modification.createDefault());
        } else {
            exist.getModification().setLastModifiedDate(new Date());
        }
        dao.update(exist);
    }

}
