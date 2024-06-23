package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.SeedAnalysisStatusCommand;

public interface AnalysisStatusCommandService {
    void handle(SeedAnalysisStatusCommand command);
}
