package com.befun.service.profile.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.befun.dao.IBaseDao;
import com.befun.domain.profile.ClientRequirement;
import com.befun.service.BaseModificationService;
import com.befun.service.profile.ClientRequirementService;

@Service("ClientRequirementService")
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class ClientRequirementServiceImpl extends BaseModificationService<ClientRequirement, Long> implements ClientRequirementService {

    @Override
    @Resource
    public void setDao(@Qualifier("ClientRequirementDao") IBaseDao<ClientRequirement, Long> dao) {
        this.dao = dao;
    }

    @Override
    public List<ClientRequirement> queryRequirements(Long clientId) {
        Assert.notNull(clientId, "Client id should be not null!");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("clientId", clientId);
        List<ClientRequirement> rs = this.dao.query("from com.befun.domain.profile.ClientRequirement", paramMap);
        return rs;
    }

}
