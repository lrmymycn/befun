package com.befun.service.profile;

import com.befun.domain.profile.ApartmentInterestListItem;
import com.befun.service.IBaseService;

public interface ApartmentInterestListItemService extends IBaseService<ApartmentInterestListItem, Long> {

    ApartmentInterestListItem getFetchList(Long id);
}
