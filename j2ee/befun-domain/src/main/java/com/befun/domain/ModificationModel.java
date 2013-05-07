package com.befun.domain;

import java.io.Serializable;


public interface ModificationModel<PK extends Serializable> extends BaseModel<PK> {

    Modification getModification();

    void setModification(Modification modification);
}
