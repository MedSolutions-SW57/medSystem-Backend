package com.losluminosos.medsystem.laboratoryservice.application.internal.commandservices;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateAnalysisCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.UpdateAnalysisCommand;
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
        if (analysisRepository.existsBySampleId(command.SampleId())) {
            throw new IllegalArgumentException("Analysis with sample id " + command.SampleId() + " already exists");
        }
        var analysis = new Analysis(command.AnalysisType(), command.SampleId(), command.PatientDni(), command.Date(), analysisStatusRepository.findById(command.Status()).get());
        analysisRepository.save(analysis);
        return Optional.of(analysis);
    }

    @Override
    public Optional<Analysis> handle(UpdateAnalysisCommand command) {
        return Optional.empty();
    }
}
