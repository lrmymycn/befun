package com.befun.mail;

import java.io.File;
import java.util.Map;

public class MailContent {

    private String content;

    private Map<String, File> multiAttachments;

    private Map<String, File> textAttachments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, File> getMultiAttachments() {
        return multiAttachments;
    }

    public void setMultiAttachments(Map<String, File> multiAttachments) {
        this.multiAttachments = multiAttachments;
    }

    public Map<String, File> getTextAttachments() {
        return textAttachments;
    }

    public void setTextAttachments(Map<String, File> textAttachments) {
        this.textAttachments = textAttachments;
    }

}
