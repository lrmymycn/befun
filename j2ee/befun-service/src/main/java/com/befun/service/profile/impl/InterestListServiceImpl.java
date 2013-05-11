package com.befun.service.profile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final static String HQL_QUERY_BYCLIENT = "from com.befun.domain.profile.InterestList il where il.clientId = :clientId";

    @Resource
    public void setDao(@Qualifier("InterestListDao") IBaseDao<InterestList, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<InterestList> queryByClient(Long clientId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("clientId", clientId);
        return this.dao.query(HQL_QUERY_BYCLIENT, paramMap);
    }

    @Override
    public List<InterestList> queryByClientFetchItem(Long clientId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("clientId", clientId);
        List<InterestList> rs = this.dao.query(HQL_QUERY_BYCLIENT, paramMap);
        for (InterestList l : rs) {
            l.getApartments().size();
            l.getFloorplans().size();
        }
        return rs;
    }

    @Override
    public InterestList createForClient(Long clientId) {
        InterestList list = new InterestList();
        list.setClientId(clientId);
        this.save(list);
        return list;
    }

}
