package com.losluminosos.medsystem.medicalservice.domain.model.queries;

public record GetReportsByPatientIdQuery(Long patientId) {
    public GetReportsByPatientIdQuery {
        if (patientId == null || patientId < 0){
            throw new IllegalArgumentException("Patient ID cannot be null or les than 0");
        }
    }
}
