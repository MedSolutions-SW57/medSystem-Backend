package com.losluminosos.medsystem.laboratoryservice.application.internal.queryservices;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllAnalysisQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAnalysisByIdQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.services.AnalysisQueryService;
import com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories.AnalysisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisQueryServiceImpl implements AnalysisQueryService {
    private final AnalysisRepository analysisRepository;

    public AnalysisQueryServiceImpl(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Override
    public List<Analysis> handle(GetAllAnalysisQuery query){
        return analysisRepository.findAll();
    }

    @Override
    public Analysis handle(GetAnalysisByIdQuery query) {
        return analysisRepository.findById(query.analysisId()).orElse(null);
    }
}
