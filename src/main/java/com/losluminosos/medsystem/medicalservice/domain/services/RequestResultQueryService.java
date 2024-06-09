package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;

import java.util.List;

public interface RequestResultQueryService {
    List<Result> getByDoctorId(String doctorId);
    List<Result> getByPatientId(String patientId);
}