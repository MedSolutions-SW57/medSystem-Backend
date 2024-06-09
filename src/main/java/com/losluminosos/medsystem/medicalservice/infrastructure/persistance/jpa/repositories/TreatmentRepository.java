package com.losluminosos.medsystem.medicalservice.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    boolean existsByTreatmentName(String treatmentName);
}
