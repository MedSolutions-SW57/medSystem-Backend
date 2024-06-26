package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.AnalysisResource;

public class AnalysisResourceFromEntityAssembler {
    public static AnalysisResource toResourceFromEntity(Analysis entity) {
        return new AnalysisResource(
            entity.getId(),
            entity.getAnalysisType(),
            entity.getSampleId(),
            entity.getPatientId(),
            entity.getDate(),
            entity.getStatus().getStringName());
    }
}
