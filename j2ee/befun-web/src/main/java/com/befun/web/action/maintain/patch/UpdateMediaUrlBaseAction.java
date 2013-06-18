package com.befun.web.action.maintain.patch;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.befun.domain.estate.Media;
import com.befun.service.estate.MediaService;
import com.befun.util.media.MediaPathAdjustService;
import com.befun.web.action.BaseAction;

@Controller("UpdateMediaUrlBaseAction")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UpdateMediaUrlBaseAction extends BaseAction {

    private static final long      serialVersionUID = -4842427387559162277L;

    @Resource
    @Qualifier("MediaPathAdjustService")
    private MediaPathAdjustService mediaPathAdjustService;

    private Long                   mediaId;

    @Resource
    @Qualifier("MediaService")
    private MediaService           mediaService;

    public String updateUrl() {
        try {
            mediaPathAdjustService.adjustAllMedias();
            this.addActionMessage("Update URL successfully!");
        } catch (Exception ex) {
            String errMsg = "Update URL failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String testUpdateUrl() {
        try {
            Media media = mediaService.get(mediaId);
            mediaPathAdjustService.adjustMedia(media);
            this.addActionMessage("Update URL successfully!");
        } catch (Exception ex) {
            String errMsg = "Update URL failure!";
            this.log.error(errMsg, ex);
            this.addActionError(errMsg + "\nCause:" + ex.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

}
