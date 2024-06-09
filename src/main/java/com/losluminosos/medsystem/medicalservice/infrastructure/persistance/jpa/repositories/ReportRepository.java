package com.losluminosos.medsystem.medicalservice.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    boolean existsByDateAndReason(String date, String reason);
}
