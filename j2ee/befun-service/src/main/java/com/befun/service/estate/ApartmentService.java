package com.befun.service.estate;

import java.util.List;

import com.befun.domain.PaginationBean;
import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;
import com.befun.service.query.ApartmentQueryCondition;

public interface ApartmentService extends BaseEstateService<Apartment, Long> {

    List<Floorplan> queryFloorplans(ApartmentQueryCondition apQC);

    PaginationBean<Floorplan> queryFloorplans(ApartmentQueryCondition apQC, long pageNumber, int pageSize);
}
