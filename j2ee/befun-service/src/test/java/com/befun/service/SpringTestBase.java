package com.befun.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context-datasource.xml" })
//@Transactional
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class SpringTestBase {

}
