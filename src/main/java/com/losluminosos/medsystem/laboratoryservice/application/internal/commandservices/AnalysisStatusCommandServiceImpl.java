package com.losluminosos.medsystem.laboratoryservice.application.internal.commandservices;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.SeedAnalysisStatusCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;
import com.losluminosos.medsystem.laboratoryservice.domain.model.valueobjects.Status;
import com.losluminosos.medsystem.laboratoryservice.domain.services.AnalysisStatusCommandService;
import com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories.AnalysisStatusRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnalysisStatusCommandServiceImpl implements AnalysisStatusCommandService{
    private final AnalysisStatusRepository analysisStatusRepository;

    public AnalysisStatusCommandServiceImpl(AnalysisStatusRepository analysisStatusRepository) {
        this.analysisStatusRepository = analysisStatusRepository;
    }
    @Override
    public void handle(SeedAnalysisStatusCommand command) {
        Arrays.stream(Status.values()).forEach(status -> {
            if(!analysisStatusRepository.existsByStatus(status)) {
                analysisStatusRepository.save(new AnalysisStatus(status));
            }
        });
    }
}
