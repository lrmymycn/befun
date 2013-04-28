package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Apartment;
import com.befun.service.estate.ApartmentService;

@Service("ApartmentService")
@Transactional(rollbackFor = Exception.class)
public class ApartmentServiceImpl extends BaseEstateServiceImpl<Apartment, Long> implements ApartmentService {

    @Override
    @Resource
    public void setDao(@Qualifier("ApartmentDao") IBaseDao<Apartment, Long> dao) {
        this.dao = dao;
    }

}
