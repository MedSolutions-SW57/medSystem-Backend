package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.RequestResult;

import java.util.List;

public interface RequestResultQueryService {
    List<RequestResult> getByDoctorId(String doctorId);
    List<RequestResult> getByPatientId(String patientId);
}