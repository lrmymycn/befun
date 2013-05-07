package com.befun.service.estate.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.QueryCondition;
import com.befun.dao.estate.SuburbPolylineDao;
import com.befun.domain.estate.Suburb;
import com.befun.domain.estate.SuburbPolyline;
import com.befun.service.estate.SuburbService;
import com.befun.service.query.estate.SuburbQueryCondition;

@Service("SuburbService")
@Transactional(rollbackFor = Exception.class)
public class SuburbServiceImpl extends BaseEstateServiceImpl<Suburb, Long> implements SuburbService {

    @Resource
    @Qualifier("SuburbPolylineDao")
    private SuburbPolylineDao polylineDao;
    
    @Override
    public List<Suburb> queryByInputKey(String key) {
        SuburbQueryCondition queryCondition = new SuburbQueryCondition();
        queryCondition.setKey(key);
        List<Suburb> rs = this.dao.query(queryCondition);
        return rs;
    }

    @Override
    public Suburb getDetail(Long id) {
        Suburb model = this.get(id);
        model.getPolylines().size();
        return model;
    }
    
    @Override
    public void saveOrUpdateWithPolylines(Suburb model, String[] ignoreProps) {
        List<SuburbPolyline> polylines = new ArrayList<SuburbPolyline>();
        if (model.getPolylines() != null) {
            for (SuburbPolyline p : model.getPolylines()) {
                polylines.add(p);
            }
        }
        if (model.getId() != null) {
            this.update(model, ignoreProps);
        } else {
            this.save(model);
        }
        IQueryCondition pQC = new QueryCondition();
        pQC.setHql(true);
        pQC.setHqlString("from com.befun.domain.estate.SuburbPolyline p WHERE p.suburb.id = :suburbId");
        pQC.setParameter("suburbId", model.getId());
        List<SuburbPolyline> existsPls = polylineDao.query(pQC);
        for (SuburbPolyline p : existsPls) {
            polylineDao.deleteObject(p);
        }
        for (SuburbPolyline p : polylines) {
            p.setSuburb(model);
            polylineDao.save(p);
        }
    }
    
    @Override
    @Resource
    public void setDao(@Qualifier("SuburbDao") IBaseDao<Suburb, Long> dao) {
        this.dao = dao;
    }

}
