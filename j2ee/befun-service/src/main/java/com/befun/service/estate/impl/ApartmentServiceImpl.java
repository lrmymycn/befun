package com.befun.service.estate.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.PaginationBean;
import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.service.estate.ApartmentService;
import com.befun.service.query.QCUtils;
import com.befun.service.query.estate.ApartmentQueryCondition;

@Service("ApartmentService")
@Transactional(rollbackFor = Exception.class)
public class ApartmentServiceImpl extends BaseEstateServiceImpl<Apartment, Long> implements ApartmentService {

    @Override
    @Resource
    public void setDao(@Qualifier("ApartmentDao") IBaseDao<Apartment, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<Floorplan> queryFloorplans(ApartmentQueryCondition apQC) {
        if (apQC != null) {
            ProjectionList projections = Projections.projectionList();
            projections.add(Projections.distinct(Projections.property(QCUtils.generatePropertyName(apQC.getSelfAlias(), "floorplan"))));
            apQC.setProjections(projections);
        }
        return this.dao.queryFree(apQC);
    }

    @Override
    public PaginationBean<Floorplan> queryFloorplans(ApartmentQueryCondition apQC, long pageNumber, int pageSize) {
        if (apQC != null) {
            ProjectionList projections = Projections.projectionList();
            projections.add(Projections.distinct(Projections.property(apQC.getFloorplanAlias())));
            apQC.setProjections(projections);
        }
        return this.dao.queryFree(apQC, pageNumber, pageSize);
    }

    @Override
    public void markSoldOut(Long id) {
        Apartment model = this.get(id);
        if(model == null){
            return;
        }
        model.setSoldOut(true);
        this.update(model);
    }

}
