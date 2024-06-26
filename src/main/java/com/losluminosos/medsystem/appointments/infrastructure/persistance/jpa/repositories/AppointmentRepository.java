package com.losluminosos.medsystem.appointments.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByDoctorId(Long id);
    List<Appointment> findAllByPatientId(Long id);
    boolean existsByDate(String date);
}

