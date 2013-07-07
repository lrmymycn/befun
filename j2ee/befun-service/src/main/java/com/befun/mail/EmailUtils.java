package com.befun.mail;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtils {

    private Log log = LogFactory.getLog(this.getClass());

    private String mailServerHost = "localhost";

    private String defaultFrom = "noreply@befun.com.au";

    public void sendMail(List<String> to, List<String> cc, String subject, MailContent mailContent) throws MessagingException {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

        // 设定mail server
        senderImpl.setHost(mailServerHost);
        // 建立HTML邮件消息
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        // true表示开始附件模式
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, false, "utf-8");

        // 设置收件人，寄件人
        if (to != null) {
            messageHelper.setTo(to.toArray(new String[] {}));
        }
        if (cc != null) {
            messageHelper.setCc(cc.toArray(new String[] {}));
        }
        messageHelper.setFrom(this.defaultFrom);
        messageHelper.setSubject(subject);
        // true 表示启动HTML格式的邮件
        messageHelper.setText(mailContent.getContent(), true);

        // FileSystemResource file1 = new FileSystemResource(new File("d:/logo.jpg"));
        // FileSystemResource file2 = new FileSystemResource(new File("d:/读书.txt"));
        // // 添加2个附件
        // messageHelper.addAttachment("logo.jpg", file1);
        //
        // try {
        // // 附件名有中文可能出现乱码
        // messageHelper.addAttachment(MimeUtility.encodeWord("读书.txt"), file2);
        // } catch (UnsupportedEncodingException e) {
        // e.printStackTrace();
        // throw new MessagingException();
        // }
        // 发送邮件
        senderImpl.send(mailMessage);
        log.debug("邮件发送成功.....");
    }

}
