package com.losluminosos.medsystem.medicalservice.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    boolean existsByDateAndReasonAndPatientId(String date, String reason, Long patientId);
    List<Report> findAllReportsByPatientId(Long patientId);
}
