package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;

import java.util.List;

public interface ResultQueryService {
    List<Result> getByDoctorId(Long doctorId);
    List<Result> getByPatientId(Long patientId);
}