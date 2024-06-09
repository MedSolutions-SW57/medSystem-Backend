package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record CreateHistoryResource(String reason, String date, String patientId, String doctorId) {
    public CreateHistoryResource {
        if(reason == null || reason.isBlank()){
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
        if(date == null || date.isBlank()){
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if(patientId == null || patientId.isBlank()){
            throw new IllegalArgumentException("PatientId cannot be null or empty");
        }
        if(doctorId == null || doctorId.isBlank()){
            throw new IllegalArgumentException("DoctorId cannot be null or empty");
        }
    }
}
