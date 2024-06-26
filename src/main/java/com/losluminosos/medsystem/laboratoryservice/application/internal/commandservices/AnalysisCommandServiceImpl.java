package com.losluminosos.medsystem.laboratoryservice.application.internal.commandservices;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateAnalysisCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.UpdateAnalysisCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;
import com.losluminosos.medsystem.laboratoryservice.domain.services.AnalysisCommandService;
import com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories.AnalysisRepository;
import com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories.AnalysisStatusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnalysisCommandServiceImpl implements AnalysisCommandService {
    private final AnalysisRepository analysisRepository;
    private final AnalysisStatusRepository analysisStatusRepository;

    public AnalysisCommandServiceImpl(AnalysisRepository analysisRepository, AnalysisStatusRepository analysisStatusRepository) {
        this.analysisRepository = analysisRepository;
        this.analysisStatusRepository = analysisStatusRepository;
    }

    @Override
    public Optional<Analysis> handle(CreateAnalysisCommand command){
        if(!analysisStatusRepository.existsByStatus(command.status().getStatus()))
            throw new IllegalArgumentException("Status doesnt exists");
        var analysis = new Analysis(command.analysisType(), command.sampleId(), command.patientId(), command.date(), analysisStatusRepository.findByStatus(command.status().getStatus()).get());
        analysisRepository.save(analysis);
        return Optional.of(analysis);
    }

    @Override
    public Optional<Analysis> handle(UpdateAnalysisCommand command) {
        var result = analysisRepository.findById(command.analysisId());
        if(result.isEmpty()) throw new IllegalArgumentException("Analysis does not exist");
        var analysisToUpdate = result.get();
        try {
            var updatedAnalysis = analysisRepository.save(analysisToUpdate.updateStatus(command.status()));
            return Optional.of(updatedAnalysis);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating analysis: " + e.getMessage());
        }
    }
}
