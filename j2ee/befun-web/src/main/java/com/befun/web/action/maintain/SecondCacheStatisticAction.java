package com.befun.web.action.maintain;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.befun.web.action.BaseAction;

@Controller("SecondCacheStatisticAction")
public class SecondCacheStatisticAction extends BaseAction {

    private static final long serialVersionUID = -5231891328688966947L;

    @Resource
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public String statistic() {
        Statistics st = this.sessionFactory.getStatistics();
        this.log.info(st);
        
        this.log.info("================== SecondLevelCache ==================");
        String[] regionNames = st.getSecondLevelCacheRegionNames();
        for (String regionName : regionNames) {
            this.log.info("================== Region:" + regionName + " ==================");
            this.log.info(st.getSecondLevelCacheStatistics(regionName));
            this.log.info("");
        }
        return SUCCESS;
    }
}
