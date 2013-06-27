package com.befun.service.estate;

import java.util.Map;

import com.befun.domain.estate.Area;
import com.befun.domain.estate.Project;
import com.befun.domain.estate.Suburb;
import com.befun.service.query.estate.ProjectQueryCondition;

public interface ProjectService extends BaseEstateService<Project, Long> {

    Map<Area, Long> queryGroupByArea(ProjectQueryCondition qc);

    Map<Suburb, Long> queryGroupBySuburb(ProjectQueryCondition qc);

    void deleteDeep(long id);
}
