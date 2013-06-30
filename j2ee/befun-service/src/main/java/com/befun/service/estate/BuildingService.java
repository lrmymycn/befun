package com.befun.service.estate;

import com.befun.domain.estate.Building;

public interface BuildingService extends BaseEstateService<Building, Long> {

    void deleteDependency(Long id);
}
