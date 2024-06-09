package com.losluminosos.medsystem.medicalservice.domain.model.commands;

public record CreateReportCommand(String reason, String date, String patientId, String doctorName) {
    public CreateReportCommand {
        if(reason == null || reason.isEmpty()){
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
        if(date == null || date.isEmpty()){
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if(patientId == null || patientId.isEmpty()){
            throw new IllegalArgumentException("PatientId cannot be null or empty");
        }
        if(doctorName == null || doctorName.isEmpty()){
            throw new IllegalArgumentException("DoctorName cannot be null or empty");
        }
    }
}
