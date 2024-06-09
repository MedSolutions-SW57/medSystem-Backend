package com.losluminosos.medsystem.medicalservice.domain.model.commands;

public record CreateHistoryCommand(String reason, String date, String patientId, String doctorId){
    public CreateHistoryCommand {
        if(reason == null || reason.isEmpty()){
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
        if(date == null || date.isEmpty()){
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if(patientId == null || patientId.isEmpty()){
            throw new IllegalArgumentException("PatientId cannot be null or empty");
        }
        if(doctorId == null || doctorId.isEmpty()){
            throw new IllegalArgumentException("DoctorId cannot be null or empty");
        }
    }
}
