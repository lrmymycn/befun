package com.befun.service.profile;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.service.SpringTestBase;

public class TestInterestListService extends SpringTestBase {

    @Resource
    @Qualifier("InterestListService")
    private InterestListService target;

    @Test
    public void testQueryByClient() {
        target.queryByClient(11l);
    }


    @Test
    public void testQueryByClientFetch() {
        target.queryByClientFetchItem(11l);
    }

}
