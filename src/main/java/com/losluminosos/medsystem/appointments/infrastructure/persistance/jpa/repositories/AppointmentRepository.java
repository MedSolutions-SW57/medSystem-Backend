package com.losluminosos.medsystem.appointments.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.valueobjects.AppointmentTimePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Buscar una cita por fecha y hora específica
    Optional<Appointment> findByAppointmentTimePoint(AppointmentTimePoint appointmentTimePoint);

    // Verificar si existe una cita en una fecha y hora específica
    boolean existsByAppointmentTimePoint(AppointmentTimePoint appointmentTimePoint);

}

