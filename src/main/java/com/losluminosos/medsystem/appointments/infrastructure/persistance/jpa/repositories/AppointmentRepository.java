package com.losluminosos.medsystem.appointments.infrastructure.persistance.jpa.repositories;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Buscar una cita por fecha y hora específica
    Optional<Appointment> findByAppointmentDateTime_AppointmentDateAndAppointmentDateTime_AppointmentTime(String appointmentDate, String appointmentTime);

    // Verificar si existe una cita en una fecha y hora específica
    boolean existsByAppointmentDateTime_AppointmentDateAndAppointmentDateTime_AppointmentTime(String appointmentDate, String appointmentTime);
}

