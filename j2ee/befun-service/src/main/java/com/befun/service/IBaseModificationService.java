package com.befun.service;

import java.io.Serializable;

import com.befun.domain.ModificationModel;

public interface IBaseModificationService<M extends ModificationModel<PK>, PK extends Serializable> extends IBaseService<M, PK> {

}
