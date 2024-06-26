package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

public record CreateAnalysisCommand(String analysisType,String sampleId, Long patientId, String date, Long status) {
}
