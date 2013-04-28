package com.befun.service.estate.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Suburb;
import com.befun.service.estate.SuburbService;
import com.befun.service.query.SuburbQueryCondition;

@Service("SuburbService")
@Transactional(rollbackFor = Exception.class)
public class SuburbServiceImpl extends BaseEstateServiceImpl<Suburb, Long> implements SuburbService {

    @Override
    public List<Suburb> queryByInputKey(String key) {
        SuburbQueryCondition queryCondition = new SuburbQueryCondition();
        queryCondition.setKey(key);
        List<Suburb> rs = this.dao.query(queryCondition);
        return rs;
    }

    @Override
    @Resource
    public void setDao(@Qualifier("SuburbDao") IBaseDao<Suburb, Long> dao) {
        this.dao = dao;
    }

}
