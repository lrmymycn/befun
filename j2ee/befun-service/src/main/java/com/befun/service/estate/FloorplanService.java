package com.befun.service.estate;

import com.befun.domain.estate.Floorplan;

public interface FloorplanService extends BaseEstateService<Floorplan, Long> {

    Floorplan getWithAveragePrice(Long id);

    void deleteDependency(Long id);
}
