package com.losluminosos.medsystem.appointments.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.valueobjects.AppointmentTimePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByAppointmentTimePoint(AppointmentTimePoint appointmentTimePoint);
    boolean existsByAppointmentTimePoint(AppointmentTimePoint appointmentTimePoint);

}

