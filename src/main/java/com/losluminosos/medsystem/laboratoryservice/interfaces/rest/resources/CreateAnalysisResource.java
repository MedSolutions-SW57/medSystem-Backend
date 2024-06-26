package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record CreateAnalysisResource(
        String analysisType,
        String sampleId,
        Long patientId,
        String date,
        String status
) {
}
