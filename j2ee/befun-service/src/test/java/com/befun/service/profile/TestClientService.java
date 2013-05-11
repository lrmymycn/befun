package com.befun.service.profile;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import com.befun.domain.profile.Client;
import com.befun.service.SpringTestBase;

public class TestClientService extends SpringTestBase {

    @Resource
    @Qualifier("ClientService")
    private ClientService target;


    @Test
    public void testGetClientById() {
        Client client = target.get(11l);
        System.out.println(client.getCurrentEmployee());
    }

}
