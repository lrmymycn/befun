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
import com.befun.dao.estate.AreaPolylineDao;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.AreaPolyline;
import com.befun.service.estate.AreaService;
import com.befun.service.query.AreaQueryCondition;

@Service("AreaService")
@Transactional(rollbackFor = Exception.class)
public class AreaServiceImpl extends BaseEstateServiceImpl<Area, Long> implements AreaService {

    @Override
    @Resource
    public void setDao(@Qualifier("AreaDao") IBaseDao<Area, Long> dao) {
        this.dao = dao;
    }

    @Resource
    @Qualifier("AreaPolylineDao")
    private AreaPolylineDao polylineDao;

    @Override
    public List<Area> queryByName(String name) {
        AreaQueryCondition queryCondition = new AreaQueryCondition();
        queryCondition.setName(name);
        List<Area> rs = this.dao.query(queryCondition);
        return rs;
    }

    @Override
    public Area getDetail(Long id) {
        Area model = this.get(id);
        model.getPolylines().size();
        return model;
    }

    @Override
    public void saveOrUpdateWithPolylines(Area model, String[] ignoreProps) {
        List<AreaPolyline> polylines = new ArrayList<AreaPolyline>();
        if (model.getPolylines() != null) {
            for (AreaPolyline p : model.getPolylines()) {
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
        pQC.setHqlString("from com.befun.domain.estate.AreaPolyline p WHERE p.area.id = :areaId");
        pQC.setParameter("areaId", model.getId());
        List<AreaPolyline> existsPls = polylineDao.query(pQC);
        for (AreaPolyline p : existsPls) {
            polylineDao.deleteObject(p);
        }
        for (AreaPolyline p : polylines) {
            p.setArea(model);
            polylineDao.save(p);
        }
    }

}
