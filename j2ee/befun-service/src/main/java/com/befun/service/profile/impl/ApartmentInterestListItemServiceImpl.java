package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.ApartmentInterestListItem;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.ApartmentInterestListItemService;

@Service("ApartmentInterestListItemService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ApartmentInterestListItemServiceImpl extends BaseModificationService<ApartmentInterestListItem, Long> implements ApartmentInterestListItemService {

    @Resource
    public void setDao(@Qualifier("ApartmentInterestListItemDao") IBaseDao<ApartmentInterestListItem, Long> dao) {
        this.dao = dao;
    }

}
