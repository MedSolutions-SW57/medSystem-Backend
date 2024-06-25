package com.losluminosos.medsystem.laboratoryservice.application.internal.queryservices;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllSamplesByPatientIdQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllSamplesQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetSampleByCodeQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetSampleByIdQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.services.SampleQueryService;
import com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleQueryServiceImpl implements SampleQueryService {
    private final SampleRepository sampleRepository;

    public SampleQueryServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Optional<Sample> handle(GetSampleByIdQuery query) {
        return sampleRepository.findById(query.sampleId());
    }

    @Override
    public Optional<Sample> handle(GetSampleByCodeQuery query) {
        return sampleRepository.findSampleByCode(query.code());
    }

    @Override
    public List<Sample> handle(GetAllSamplesQuery query) {
        return sampleRepository.findAll();
    }

    @Override
    public List<Sample> handle(GetAllSamplesByPatientIdQuery query) {
        return sampleRepository.findAllSamplesByPatientId(query.patientId());
    }
}
