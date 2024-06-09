package com.losluminosos.medsystem.medicalservice.domain.model.queries;

public record GetReportsByPatientIdQuery(String patientId) {
    public GetReportsByPatientIdQuery {
        if (patientId == null || patientId.isBlank()){
            throw new IllegalArgumentException("Patient ID cannot be null or empty");
        }
    }
}
