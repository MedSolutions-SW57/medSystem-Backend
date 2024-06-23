package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record CreateAnalysisResource(
        String analysisType,
        String sampleId,
        String patientDni,
        String date,
        Long status
) {
}
