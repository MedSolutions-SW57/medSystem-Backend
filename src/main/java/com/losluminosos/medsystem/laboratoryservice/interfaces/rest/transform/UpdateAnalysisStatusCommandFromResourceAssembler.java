package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.UpdateAnalysisCommand;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.UpdateAnalysisStatusResource;

public class UpdateAnalysisStatusCommandFromResourceAssembler {
    public static UpdateAnalysisCommand toCommandFromResource(Long analysisId, UpdateAnalysisStatusResource resource) {
        return new UpdateAnalysisCommand(analysisId, resource.status());
    }
}
