package com.befun.web.view.converter;

import com.befun.domain.BaseModel;
import com.befun.domain.estate.ModelModification;
import com.befun.web.view.BaseEasteView;

public abstract class AbstractEstateViewConverter<M extends BaseModel<?>, V extends BaseEasteView<M>> extends BaseViewConverter<M, V> {

    public void copyModelModification(ModelModification source, V target) {
        target.setCreationDate(source.getCreationDate());
        target.setEnabled(source.isEnabled());
        target.setLastModifiedDate(source.getLastModifiedDate());
        target.setRemoved(source.isRemoved());
    }

}
