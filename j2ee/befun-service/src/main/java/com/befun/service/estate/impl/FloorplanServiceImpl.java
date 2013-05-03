package com.befun.service.estate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.domain.estate.Floorplan;
import com.befun.service.estate.FloorplanService;

@Service("FloorplanService")
@Transactional(rollbackFor = Exception.class)
public class FloorplanServiceImpl extends BaseEstateServiceImpl<Floorplan, Long> implements FloorplanService {

    @Override
    @Resource
    public void setDao(@Qualifier("FloorplanDao") IBaseDao<Floorplan, Long> dao) {
        this.dao = dao;
    }

    @Override
    public Floorplan getWithAveragePrice(Long id) {
        Floorplan rs = this.dao.get(id);
        if (rs == null) {
            this.log.debug("Can not find floorplan with id:" + id);
            return null;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("floorplanId", id);
        List<?> avgPrices = this.dao.query("select avg(ap.price) from com.befun.domain.estate.Apartment ap WHERE ap.floorplan.id = :floorplanId", paramMap);
        if (avgPrices != null && avgPrices.size() > 0) {
            Object p = avgPrices.get(0);
            Double avgPrice = (Double) p;
            rs.setAvgPricePerSQM(avgPrice/rs.getTotalSize());
        } else {
            this.log.debug("Can not find avg price of floorplan with id:" + id);
        }
        return rs;
    }

}
