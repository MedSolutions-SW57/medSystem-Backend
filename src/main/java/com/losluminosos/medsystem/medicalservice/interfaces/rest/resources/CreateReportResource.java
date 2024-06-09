package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record CreateReportResource(String reason, String date, String patientId, String doctorName) {
    public CreateReportResource {
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if (patientId == null || patientId.isBlank()) {
            throw new IllegalArgumentException("PatientId cannot be null or empty");
        }
        if (doctorName == null || doctorName.isBlank()) {
            throw new IllegalArgumentException("DoctorName cannot be null or empty");
        }
    }
}
