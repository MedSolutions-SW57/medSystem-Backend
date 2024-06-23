package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllAnalysisQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAnalysisByIdQuery;

import java.util.List;

public interface AnalysisQueryService {
    List<Analysis> handle(GetAllAnalysisQuery query);
    Analysis handle(GetAnalysisByIdQuery query);
}
