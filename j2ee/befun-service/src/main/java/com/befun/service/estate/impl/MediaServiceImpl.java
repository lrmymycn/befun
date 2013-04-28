package com.befun.service.estate.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Media;
import com.befun.service.estate.MediaService;

@Service("MediaService")
@Transactional(rollbackFor = Exception.class)
public class MediaServiceImpl extends BaseEstateServiceImpl<Media, Long> implements MediaService {

    @Override
    @Resource
    public void setDao(@Qualifier("MediaDao") IBaseDao<Media, Long> dao) {
        this.dao = dao;
    }

}
