package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record AnalysisResource(
        Long id,
        String analysisType,
        String sampleId,
        String patientDni,
        String date,
        Long status
) {
}
