package com.losluminosos.medsystem.profiles.application.internal.queryservices;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Patient;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetAllPatientsQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetPatientByIdQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetPatientByUserIdQuery;
import com.losluminosos.medsystem.profiles.domain.services.PatientQueryService;
import com.losluminosos.medsystem.profiles.infrastructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientQueryServiceImpl implements PatientQueryService {
    private final PatientRepository patientRepository;

    public PatientQueryServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<Patient> handle(GetPatientByIdQuery query) {
        return patientRepository.findById(query.id());
    }

    @Override
    public Optional<Patient> handle(GetPatientByUserIdQuery query) {
        return patientRepository.findByUserId(query.id());
    }

    @Override
    public List<Patient> handle(GetAllPatientsQuery query) {
        return patientRepository.findAll();
    }
}
