package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

public record CreateAnalysisCommand(String TestType,String SampleId, String PatientDni, String Date, String Status) {
}
