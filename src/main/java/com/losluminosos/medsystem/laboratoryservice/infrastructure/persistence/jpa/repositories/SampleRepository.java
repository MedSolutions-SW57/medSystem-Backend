package com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    boolean existsByCode(String code);
    Optional<Sample> findSampleByCode(String code);
    List<Sample> findAllSamplesByPatientId(Long patientId);
}
