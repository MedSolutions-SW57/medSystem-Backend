package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;

public record CreateAnalysisCommand(String analysisType, String sampleId, Long patientId, String date, AnalysisStatus status) {
}
