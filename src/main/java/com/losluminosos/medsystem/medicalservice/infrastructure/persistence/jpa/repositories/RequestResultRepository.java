package com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByDoctorId(String doctorId);
    List<Result> findByPatientId(String patientId);
}