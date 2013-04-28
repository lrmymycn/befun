package com.befun.service.estate;

import java.util.List;

import com.befun.domain.estate.Suburb;

public interface SuburbService extends BaseEstateService<Suburb, Long> {

    List<Suburb> queryByInputKey(String key);
}
