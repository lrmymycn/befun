package com.befun.util.schedule;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Order;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.befun.domain.PaginationBean;
import com.befun.domain.community.CustomerMessage;
import com.befun.mail.CustomerMessageSendConfig;
import com.befun.mail.CustomerMessageSendService;
import com.befun.service.estate.CustomerMessageService;
import com.befun.service.query.QCUtils;
import com.befun.service.query.estate.CustomerMessageQueryCondition;

public class SendCustomerMessageNotifyJob extends QuartzJobBean {

    private Log log = LogFactory.getLog(this.getClass());

    private CustomerMessageService service;

    private CustomerMessageSendService sendService;

    private CustomerMessageSendConfig config;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        this.log.debug("Starting to process new customer messages...");
        CustomerMessageQueryCondition queryCondition = new CustomerMessageQueryCondition();
        queryCondition.setProcessed(false);
        queryCondition.getOrderBy().add(Order.desc(QCUtils.generatePropertyName(queryCondition.getSelfAlias(), "creationDate")));
        PaginationBean<CustomerMessage> pgb = service.query(queryCondition, 1, config.getPageSize());
        List<CustomerMessage> messages = pgb.getModels();
        for (CustomerMessage msg : messages) {
            try {
                sendService.sendMsg(msg);
            } catch (Exception ex) {
                this.log.error("Send customer message email failure!", ex);
            }
        }
        this.log.debug("Finished to process " + messages.size() + " new customer messages!");
    }

    public void setService(CustomerMessageService service) {
        this.service = service;
    }

    public void setSendService(CustomerMessageSendService sendService) {
        this.sendService = sendService;
    }

    public void setConfig(CustomerMessageSendConfig config) {
        this.config = config;
    }

}
