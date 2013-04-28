package com.befun.service.profile.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.befun.dao.IBaseDao;
import com.befun.dao.common.IQueryCondition;
import com.befun.dao.common.QueryCondition;
import com.befun.domain.profile.Profile;
import com.befun.service.BaseService;
import com.befun.service.profile.ProfileService;

@Service("ProfileService")
@Transactional(rollbackFor = Exception.class, propagation=Propagation.REQUIRED)
public class ProfileServiceImpl extends BaseService<Profile, Long> implements ProfileService {

    @Resource
    public void setDao(@Qualifier("ProfileDao") IBaseDao<Profile, Long> dao) {
        this.dao = dao;
    }

    @Override
    public Profile getByUserName(String userName) {
        IQueryCondition queryCondition = new QueryCondition();
        queryCondition.setHql(true);
        queryCondition.setHqlString("from Profile P left join fetch P.profileRoles PR left join fetch PR.role WHERE P.username=:username");
        queryCondition.setParameter("username", userName);
        List<Profile> rs = this.dao.query(queryCondition);
        if (rs.size() == 0) {
            return null;
        }
        return rs.get(0);
    }

}
