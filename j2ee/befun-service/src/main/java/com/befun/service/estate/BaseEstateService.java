package com.befun.service.estate;

import java.io.Serializable;

import com.befun.domain.BaseEstateModel;
import com.befun.service.IBaseService;

public interface BaseEstateService<M extends BaseEstateModel<PK>, PK extends Serializable> extends IBaseService<M, PK> {

    void enable(PK id);
    
    void disable(PK id);
}
