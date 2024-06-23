package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;

public record UpdateAnalysisCommand(Long analysisId, AnalysisStatus status) {
}
