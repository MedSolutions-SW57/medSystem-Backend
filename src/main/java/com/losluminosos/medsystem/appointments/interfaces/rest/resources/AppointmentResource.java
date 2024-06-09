package com.losluminosos.medsystem.appointments.interfaces.rest.resources;

public record AppointmentResource(
        Long id,
        String doctorId,
        String patientId,
        String reason,
        String appointmentTimePoint
) { }
