package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllAnalysisQuery;

import java.util.List;

public interface AnalysisQueryService {
    List<Analysis> handle(GetAllAnalysisQuery query);
}
