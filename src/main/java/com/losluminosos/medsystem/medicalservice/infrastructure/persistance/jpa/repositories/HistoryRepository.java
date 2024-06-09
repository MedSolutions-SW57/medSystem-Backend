package com.losluminosos.medsystem.medicalservice.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    boolean existsByPatientId(String patientId);
}
