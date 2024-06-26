package com.losluminosos.medsystem.medicalservice.domain.model.commands;

public record CreateReportCommand(String reason, String date, Long patientId ) {
    public CreateReportCommand {
        if(reason == null || reason.isEmpty()){
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
        if(date == null || date.isEmpty()){
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if(patientId == null || patientId < 0){
            throw new IllegalArgumentException("PatientId cannot be null or less than 0");
        }
    }
}
