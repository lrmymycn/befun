package com.befun.service.estate;

import com.befun.domain.estate.ProjectMedia;

public interface ProjectMediaService extends BaseEstateService<ProjectMedia, Long> {

    void removeMediasOfProject(long projectId);

    void removeMediasOfProject(String projectBid);
}
