package com.befun.service.profile;

import java.util.List;

import com.befun.domain.profile.ClientRequirement;
import com.befun.service.IBaseModificationService;

public interface ClientRequirementService extends IBaseModificationService<ClientRequirement, Long> {

    List<ClientRequirement> queryRequirements(Long clientId);
}
