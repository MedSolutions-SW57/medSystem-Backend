package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record AnalysisResource(
        Long id,
        String analysisType,
        String sampleId,
        Long patientId,
        String date,
        String status
) {
}
