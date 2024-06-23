package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.SeedAnalysisStatusCommand;
import org.springframework.stereotype.Service;

@Service
public interface AnalysisStatusCommandService {
    void handle(SeedAnalysisStatusCommand command);
}
