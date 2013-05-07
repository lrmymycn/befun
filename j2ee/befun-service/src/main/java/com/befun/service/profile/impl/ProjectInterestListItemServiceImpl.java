package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.ProjectInterestListItem;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.ProjectInterestListItemService;

@Service("ProjectInterestListItemService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ProjectInterestListItemServiceImpl extends BaseModificationService<ProjectInterestListItem, Long> implements ProjectInterestListItemService {

    @Resource
    public void setDao(@Qualifier("ProjectInterestListItemDao") IBaseDao<ProjectInterestListItem, Long> dao) {
        this.dao = dao;
    }

}
