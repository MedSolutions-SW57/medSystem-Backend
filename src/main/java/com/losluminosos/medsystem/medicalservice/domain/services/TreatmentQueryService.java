package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetAllTreatmentsQuery;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetTreatmentByPatientIdQuery;

import java.util.List;
import java.util.Optional;

public interface TreatmentQueryService {
    List<Treatment> handle(GetAllTreatmentsQuery query);
    Optional<Treatment> handle(GetTreatmentByPatientIdQuery query);
}
