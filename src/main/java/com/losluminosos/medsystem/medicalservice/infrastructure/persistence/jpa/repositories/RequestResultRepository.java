package com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.RequestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestResultRepository extends JpaRepository<RequestResult, Long> {
    List<RequestResult> findByDoctorId(String doctorId);
    List<RequestResult> findByPatientId(String patientId);
}