package com.befun.util.media;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;

@Service("MediaPathAdjustService")
public class MediaPathAdjustService {

    @Resource
    @Qualifier("txManager")
    private HibernateTransactionManager tm;
    
    private Media
    
    public void adjustMediaOfProject(Long projectId){
        
    }
}
