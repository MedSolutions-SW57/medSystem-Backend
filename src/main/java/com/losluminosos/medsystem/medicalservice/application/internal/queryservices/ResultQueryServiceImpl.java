package com.losluminosos.medsystem.medicalservice.application.internal.queryservices;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;
import com.losluminosos.medsystem.medicalservice.domain.services.ResultQueryService;
import com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultQueryServiceImpl implements ResultQueryService {
    private final ResultRepository resultRepository;

    public ResultQueryServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> getByDoctorId(Long doctorId) {
        return resultRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Result> getByPatientId(Long patientId) {
        return resultRepository.findByPatientId(patientId);
    }
}