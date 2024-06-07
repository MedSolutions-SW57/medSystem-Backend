package com.losluminosos.medsystem.medicalservice.application.internal.queryservices;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.RequestResult;
import com.losluminosos.medsystem.medicalservice.domain.services.RequestResultQueryService;
import com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories.RequestResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestResultQueryServiceImpl implements RequestResultQueryService {
    private final RequestResultRepository requestResultRepository;

    public RequestResultQueryServiceImpl(RequestResultRepository requestResultRepository) {
        this.requestResultRepository = requestResultRepository;
    }

    @Override
    public List<RequestResult> getByDoctorId(String doctorId) {
        return requestResultRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<RequestResult> getByPatientId(String patientId) {
        return requestResultRepository.findByPatientId(patientId);
    }
}