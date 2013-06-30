package com.befun.service.estate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.domain.community.FloorplanComment;
import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.service.estate.ApartmentService;
import com.befun.service.estate.FloorplanCommentService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.query.estate.ApartmentQueryCondition;
import com.befun.service.query.estate.FloorplanCommentQueryCondition;

@Service("FloorplanService")
@Transactional(rollbackFor = Exception.class)
public class FloorplanServiceImpl extends BaseEstateServiceImpl<Floorplan, Long> implements FloorplanService {

    @Resource
    @Qualifier("FloorplanCommentService")
    private FloorplanCommentService floorplanCommentService;

    @Resource
    @Qualifier("ApartmentService")
    private ApartmentService apartmentService;

    @Override
    @Resource
    public void setDao(@Qualifier("FloorplanDao") IBaseDao<Floorplan, Long> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Floorplan get(Long id) {
        Assert.notNull(id, "id should be not null!");
        Floorplan rs = dao.get(id);
        if (rs != null) {
            if (rs.getMinPrice() != null && rs.getTotalSize().compareTo(0.0) > 0) {
                Double t = rs.getMinPrice() / rs.getTotalSize();
                rs.setAvgPricePerSQM(t.intValue());
            }
        }
        return rs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Floorplan> get(Long... ids) {
        List<Floorplan> rs = dao.get(ids);
        for (Floorplan fp : rs) {
            if (fp.getMinPrice() != null && fp.getTotalSize().compareTo(0.0) > 0) {
                Double t = fp.getMinPrice() / fp.getTotalSize();
                fp.setAvgPricePerSQM(t.intValue());
            }
        }
        return rs;
    }

    @Override
    @Transactional(readOnly = true)
    public Floorplan getWithAveragePrice(Long id) {
        Floorplan rs = this.dao.get(id);
        if (rs == null) {
            this.log.debug("Can not find floorplan with id:" + id);
            return null;
        }
        if (rs.getTotalSize().compareTo(0.0) <= 0) {
            return rs;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("floorplanId", id);
        List<?> avgPrices = this.dao.query("select avg(ap.price) from com.befun.domain.estate.Apartment ap WHERE ap.floorplan.id = :floorplanId", paramMap);
        if (avgPrices != null && avgPrices.size() > 0) {
            Object p = avgPrices.get(0);
            Double avgPrice = (Double) p;
            Double t = (avgPrice / rs.getTotalSize());
            rs.setAvgPricePerSQM(t.intValue());
        } else {
            this.log.debug("Can not find avg price of floorplan with id:" + id);
        }
        return rs;
    }

    @Override
    public void deleteDependency(Long id) {
        Assert.notNull(id, "id should be not null!");
        Floorplan floorplan = this.get(id);
        if (floorplan == null) {
            return;
        }
        FloorplanCommentQueryCondition fcQC = new FloorplanCommentQueryCondition();
        fcQC.setEnabled(null);
        
        fcQC.setFloorplanId(id);
        List<FloorplanComment> comments = this.floorplanCommentService.query(fcQC);
        this.floorplanCommentService.deleteObject(comments);

        ApartmentQueryCondition apQC = new ApartmentQueryCondition();
        apQC.setEnabled(null);
        apQC.setSoldOut(null);
        apQC.setRemoved(null);
        apQC.setFloorplanId(id);
        List<Apartment> apartments = this.apartmentService.query(apQC );
        this.apartmentService.deleteObject(apartments);
        
        this.delete(id);
    }
}
