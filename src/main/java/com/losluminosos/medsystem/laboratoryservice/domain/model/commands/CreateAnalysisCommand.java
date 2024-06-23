package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

public record CreateAnalysisCommand(String AnalysisType,String SampleId, String PatientDni, String Date, Long Status) {
}
