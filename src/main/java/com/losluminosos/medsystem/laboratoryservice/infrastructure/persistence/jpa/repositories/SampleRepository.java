package com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
    boolean existsByPatientDni(String patientDni);
    boolean existsByDoctorId(Long doctorId);
}
