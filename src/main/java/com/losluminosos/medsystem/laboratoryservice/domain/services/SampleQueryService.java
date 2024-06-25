package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllSamplesByPatientIdQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllSamplesQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetSampleByCodeQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetSampleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SampleQueryService {
    Optional<Sample> handle(GetSampleByIdQuery query);
    Optional<Sample> handle(GetSampleByCodeQuery query);
    List<Sample> handle(GetAllSamplesQuery query);
    List<Sample> handle(GetAllSamplesByPatientIdQuery query);
}
