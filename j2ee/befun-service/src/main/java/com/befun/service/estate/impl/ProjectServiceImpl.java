package com.befun.service.estate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.dao.estate.AreaDao;
import com.befun.dao.estate.SuburbDao;
import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.service.estate.ProjectService;
import com.befun.service.query.estate.EstateQueryCondition;
import com.befun.service.query.estate.ProjectQueryCondition;

@Service("ProjectService")
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl extends BaseEstateServiceImpl<Project, Long> implements ProjectService {

    @Resource
    @Qualifier("AreaDao")
    private AreaDao areaDao;

    @Resource
    @Qualifier("SuburbDao")
    private SuburbDao suburbDao;

    @Transactional(readOnly = true)
    public Map<Area, Long> queryGroupByArea(ProjectQueryCondition qc) {
        EstateQueryCondition aQc = new EstateQueryCondition();
        List<Area> allAreas = this.areaDao.query(aQc);
        System.out.println(allAreas.size());

        qc.setGroupByArea(true);
        qc.setGroupBySuburb(false);
        List<Object[]> queryRs = this.dao.queryGroup(qc);
        Map<Area, Long> result = new HashMap<Area, Long>();
        for (Area a : allAreas) {
            result.put(a, 0l);
        }

        for (Object[] st : queryRs) {
            result.put((Area) st[0], (Long) st[1]);
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Map<Suburb, Long> queryGroupBySuburb(ProjectQueryCondition qc) {
        EstateQueryCondition sQc = new EstateQueryCondition();
        List<Suburb> allSuburbs = this.suburbDao.query(sQc);
        
        qc.setGroupByArea(false);
        qc.setGroupBySuburb(true);
        List<Object[]> queryRs = this.dao.queryGroup(qc);
        Map<Suburb, Long> result = new HashMap<Suburb, Long>();
        
        for (Suburb s : allSuburbs) {
            s.getPolylines().size();
            s.getArea().getPolylines().size();
            result.put(s, 0l);
        }
        
        for (Object[] st : queryRs) {
            result.put((Suburb) st[0], (Long) st[1]);
        }
        return result;
    }

    @Resource
    public void setDao(@Qualifier("ProjectDao") IBaseDao<Project, Long> dao) {
        this.dao = dao;
    }
}
