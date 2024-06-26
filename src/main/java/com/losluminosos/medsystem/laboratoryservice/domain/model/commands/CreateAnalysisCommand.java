package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

public record CreateAnalysisCommand(String AnalysisType,String SampleId, Long patientId, String Date, Long Status) {
}
