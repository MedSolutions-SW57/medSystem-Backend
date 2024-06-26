package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateAnalysisCommand;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.CreateAnalysisResource;

public class CreateAnalysisCommandFromResourceAssembler {
    public static CreateAnalysisCommand toCommandFromResource(CreateAnalysisResource resource) {
        return new CreateAnalysisCommand(
                resource.analysisType(),
                resource.sampleId(),
                resource.patientId(),
                resource.date(),
                resource.status()
        );
    }
}
