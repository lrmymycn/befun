package com.befun.util.input.impl.access.parser;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.befun.domain.estate.Media;
import com.befun.domain.estate.ModelModification;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.ProjectMedia;
import com.befun.util.input.impl.access.AccessUtil;

public class ProjectMediaColumnParser implements ColumnParser<ProjectMedia> {

    @Override
    public ProjectMedia parse(Map<String, Object> col) {
        ProjectMedia rs = new ProjectMedia();

        String projectId = AccessUtil.getString(col, "project_id");
        if (StringUtils.isNotBlank(projectId)) {
            Project project = new Project();
            project.setBid(projectId);
            rs.setProject(project);
        } else {
            throw new IllegalArgumentException("project_id should be not null for ProjectMedia");
        }

        String mediaId = AccessUtil.getString(col, "media_id");
        if (StringUtils.isNotBlank(mediaId)) {
            Media media = new Media();
            media.setBid(mediaId);
            rs.setMedia(media);
        } else {
            throw new IllegalArgumentException("media_id should be not null for ProjectMedia");
        }
        
        rs.setSeqNum(AccessUtil.getInteger(col, "seq_num"));

        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }

}
