package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.SuburbInterestListItem;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.SuburbInterestListItemService;

@Service("SuburbInterestListItemService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class SuburbInterestListItemServiceImpl extends BaseModificationService<SuburbInterestListItem, Long> implements SuburbInterestListItemService {

    @Resource
    public void setDao(@Qualifier("SuburbInterestListItemDao") IBaseDao<SuburbInterestListItem, Long> dao) {
        this.dao = dao;
    }

}
