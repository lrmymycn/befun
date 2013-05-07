package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.InterestList;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.InterestListService;

@Service("InterestListService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class InterestListServiceImpl extends BaseModificationService<InterestList, Long> implements InterestListService {

    @Resource
    public void setDao(@Qualifier("InterestListDao") IBaseDao<InterestList, Long> dao) {
        this.dao = dao;
    }

}
