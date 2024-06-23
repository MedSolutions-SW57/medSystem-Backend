package com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalysisStatusRepository extends JpaRepository<AnalysisStatus, Long> {
    Optional<AnalysisStatus> findById(Long id);
    boolean existsByStatus(AnalysisStatus status);
}
