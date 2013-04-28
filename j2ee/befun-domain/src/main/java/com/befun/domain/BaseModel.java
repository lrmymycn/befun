package com.befun.domain;

import java.io.Serializable;

public interface BaseModel<PK extends Serializable> extends Serializable {

    PK getId();

    void setId(PK id);
}
