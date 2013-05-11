package com.befun.web.view.profile.converter;

import com.befun.domain.BaseModel;
import com.befun.web.view.converter.BaseViewConverter;
import com.befun.web.view.profile.BaseProfileView;

public abstract class AbstractProfileViewConverter<M extends BaseModel<?>, V extends BaseProfileView<M>> extends BaseViewConverter<M, V> {

}
