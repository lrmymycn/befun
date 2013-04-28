package com.befun.util.input.impl.access.parser;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.befun.domain.estate.ModelModification;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Stage;
import com.befun.util.input.impl.access.AccessUtil;

public class StageColumnParser implements ColumnParser<Stage> {

    @Override
    public Stage parse(Map<String, Object> col) {
        Stage rs = new Stage();
        rs.setBid(AccessUtil.getString(col, "id"));
        rs.setDescription(AccessUtil.getString(col, "description"));
        rs.setFinishDate(AccessUtil.getDate(col, "finish_date"));
        rs.setName(AccessUtil.getString(col, "name1"));

        String projectId = AccessUtil.getString(col, "project_id");
        if (StringUtils.isNotBlank(projectId)) {
            Project project = new Project();
            project.setBid(projectId);
            rs.setProject(project);
        } else {
            throw new IllegalArgumentException("project_id should be not null for Stage: " + rs.getBid());
        }

        rs.setSold(0);
        rs.setSoldOut(false);
        ModelModification modelModification = ModelModification.createDefault();
        rs.setModelModification(modelModification);
        return rs;
    }

}
