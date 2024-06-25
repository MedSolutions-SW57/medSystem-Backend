package com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

}
