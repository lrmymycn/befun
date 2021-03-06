package com.befun.web.view;

import com.befun.domain.estate.Media;
import com.befun.domain.estate.ProjectMedia;

public class ProjectMediaView extends BaseEasteView<ProjectMedia> {

    private static final long serialVersionUID = 2255410903151688539L;

    private Long projectId;

    private String projectName;

    private Media media;

    private Integer seqNum;

    public ProjectMediaView() {
        super();
    }

    public ProjectMediaView(ProjectMedia model) {
        super(model);
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    @Override
    public String toString() {
        return "ProjectMediaView [projectId=" + projectId + ", projectName=" + projectName + ", media=" + media + ", getId()=" + getId() + "]";
    }

}
