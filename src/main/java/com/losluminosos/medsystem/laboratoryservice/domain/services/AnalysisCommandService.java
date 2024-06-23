package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateAnalysisCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.UpdateAnalysisCommand;

import java.util.Optional;

public interface AnalysisCommandService {
    Optional<Analysis> handle(CreateAnalysisCommand command);
    Optional<Analysis> handle(UpdateAnalysisCommand command);
}
