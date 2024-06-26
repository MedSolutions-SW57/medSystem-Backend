package com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    boolean existsByTreatmentNameAndPatientId(String treatmentName, Long patientId);
    Optional<Treatment> findByPatientId(Long patientId);
    Optional<Treatment> findByTreatmentName(String treatmentName);
}
