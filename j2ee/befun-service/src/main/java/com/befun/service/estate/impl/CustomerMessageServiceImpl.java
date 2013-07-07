package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.community.CustomerMessage;
import com.befun.service.BaseService;
import com.befun.service.estate.CustomerMessageService;

@Service("CustomerMessageService")
@Transactional(rollbackFor = Exception.class)
public class CustomerMessageServiceImpl extends BaseService<CustomerMessage, Long> implements CustomerMessageService {

    @Override
    @Resource
    public void setDao(@Qualifier("CustomerMessageDao") IBaseDao<CustomerMessage, Long> dao) {
        this.dao = dao;
    }

}
