package com.befun.web.action.maintain;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.befun.web.action.BaseAction;
import com.befun.web.view.cachest.CacheStatisticsView;

@Controller("CacheStatisticAction")
public class CacheStatisticAction extends BaseAction {

    private static final long serialVersionUID = -5231891328688966947L;

    private Statistics st;

    private List<CacheStatisticsView<SecondLevelCacheStatistics>> secondCacheStatistics;

    private int secondCacheStatisticsSize;

    @Resource
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public String statistic() {
        st = this.sessionFactory.getStatistics();
        this.log.info(st);

        secondCacheStatistics = new ArrayList<CacheStatisticsView<SecondLevelCacheStatistics>>();
        String[] regionNames = st.getSecondLevelCacheRegionNames();
        SecondLevelCacheStatistics cst = null;
        CacheStatisticsView<SecondLevelCacheStatistics> cstView = null;
        for (String regionName : regionNames) {
            cst = st.getSecondLevelCacheStatistics(regionName);
            cstView = new CacheStatisticsView<SecondLevelCacheStatistics>(regionName, cst);
            secondCacheStatistics.add(cstView);
        }
        secondCacheStatisticsSize = secondCacheStatistics.size();
        return SUCCESS;
    }

    public List<CacheStatisticsView<SecondLevelCacheStatistics>> getSecondCacheStatistics() {
        return secondCacheStatistics;
    }

    public int getSecondCacheStatisticsSize() {
        return secondCacheStatisticsSize;
    }

    public void setSecondCacheStatisticsSize(int secondCacheStatisticsSize) {
        this.secondCacheStatisticsSize = secondCacheStatisticsSize;
    }

}
