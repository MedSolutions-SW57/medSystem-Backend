package com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    boolean existsByTreatmentNameAndPatientId(String treatmentName, Long patientId);
    List<Treatment> findAllByPatientId(Long patientId);
    Optional<Treatment> findByTreatmentName(String treatmentName);
}
