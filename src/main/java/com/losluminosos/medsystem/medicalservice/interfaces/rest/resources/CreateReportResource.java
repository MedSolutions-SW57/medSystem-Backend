package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record CreateReportResource(String reason, String date, Long patientId) {
    public CreateReportResource {
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if (patientId == null || patientId < 0) {
            throw new IllegalArgumentException("PatientId cannot be null or less than 0");
        }
    }
}
