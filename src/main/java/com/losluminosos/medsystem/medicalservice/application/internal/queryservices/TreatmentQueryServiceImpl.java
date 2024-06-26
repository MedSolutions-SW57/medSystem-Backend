package com.losluminosos.medsystem.medicalservice.application.internal.queryservices;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetAllTreatmentsQuery;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetTreatmentByPatientIdQuery;
import com.losluminosos.medsystem.medicalservice.domain.services.TreatmentQueryService;
import com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentQueryServiceImpl implements TreatmentQueryService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentQueryServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public List<Treatment> handle(GetAllTreatmentsQuery query) {
        return treatmentRepository.findAll();
    }

    @Override
    public Optional<Treatment> handle(GetTreatmentByPatientIdQuery query) {
        return treatmentRepository.findByPatientId(query.patientId());
    }
}
