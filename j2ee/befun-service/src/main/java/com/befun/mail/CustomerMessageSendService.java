package com.befun.mail;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.befun.domain.community.CustomerMessage;
import com.befun.domain.estate.Floorplan;
import com.befun.domain.estate.Project;
import com.befun.service.estate.CustomerMessageService;
import com.befun.service.estate.FloorplanService;
import com.befun.service.estate.ProjectService;

@Service("CustomerMessageSendService")
@Transactional(rollbackFor = Exception.class)
public class CustomerMessageSendService {

    private Log log = LogFactory.getLog(this.getClass());

    @Resource
    @Qualifier("CustomerMessageService")
    private CustomerMessageService service;

    @Resource
    @Qualifier("ProjectService")
    private ProjectService projectService;
    
    @Resource
    @Qualifier("FloorplanService")
    private FloorplanService floorplanService;

    @Resource
    @Qualifier("EmailUtils")
    private EmailUtils emailUtils;

    @Resource
    @Qualifier("CustomerMessageSendConfig")
    private CustomerMessageSendConfig config;

    public void sendMsg(CustomerMessage msg) throws MessagingException {
        this.log.debug("Starting to send message...");
        List<String> to = config.getTo();
        List<String> cc = config.getCc();

        String subject = "New Message from Customer:" + msg.getCustomerName();
        MailContent mailContent = new MailContent();
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(msg.getCustomerName()).append("<br/>");
        sb.append("Email: ").append(msg.getCustomerEmail()).append("<br/>");
        sb.append("Mobile: ").append(msg.getCustomerMobile()).append("<br/>");
        if (msg.getFloorplanId() != null) {
            Floorplan fp = floorplanService.get(msg.getFloorplanId());
            if (fp != null) {
                sb.append("Floorplan: ").append("<a href=\"http://www.befun.com.au/befun-web/estate/demandFloorplanDetail.action?id=").append(msg.getFloorplanId())
                  .append("\">");
                sb.append(fp.getId()).append("</a>").append("<br/>");
            }
            sb.append("Floorplan: ").append("none");
        }
        if (msg.getProjectId() != null) {
            Project pro = projectService.get(msg.getProjectId());
            if (pro != null) {
                sb.append("Project: ").append("<a href=\"http://www.befun.com.au/befun-web/estate/demandProjectDetail.action?id=").append(msg.getProjectId())
                  .append("\">");
                sb.append(pro.getName()).append("</a>").append("<br/>");
            }
        }
        sb.append(replaceNewLine(msg.getContent())).append("<br/>");
        mailContent.setContent(sb.toString());
        msg.setProcessed(true);
        msg.setProcessDate(new Date());
        this.service.update(msg);
        emailUtils.sendMail(to, cc, subject, mailContent);
        this.log.debug("Finished to send message!");
    }
    
    private String replaceNewLine(String content){
        if(StringUtils.isBlank(content)){
            return "";
        }
        return content.replaceAll("\n", "<br/>");
    }

}
