package com.befun.service.profile;

import java.util.List;

import com.befun.domain.profile.InterestList;
import com.befun.service.IBaseService;

public interface InterestListService extends IBaseService<InterestList, Long> {

    List<InterestList> queryByClient(Long clientId);

    List<InterestList> queryByClientFetchItem(Long clientId);
    
    InterestList createForClient(Long clientId);
}
