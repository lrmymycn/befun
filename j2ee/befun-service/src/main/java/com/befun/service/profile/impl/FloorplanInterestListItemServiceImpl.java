package com.befun.service.profile.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.FloorplanInterestListItem;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.FloorplanInterestListItemService;

@Service("FloorplanInterestListItemService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class FloorplanInterestListItemServiceImpl extends BaseModificationService<FloorplanInterestListItem, Long> implements FloorplanInterestListItemService {

    @Resource
    public void setDao(@Qualifier("FloorplanInterestListItemDao") IBaseDao<FloorplanInterestListItem, Long> dao) {
        this.dao = dao;
    }

    @Override
    public FloorplanInterestListItem getFetchList(Long id) {
        FloorplanInterestListItem rs = this.get(id);
        rs.getInterestList().getClientId();
        return rs;
    }

}
