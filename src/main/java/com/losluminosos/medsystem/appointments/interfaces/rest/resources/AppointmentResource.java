package com.losluminosos.medsystem.appointments.interfaces.rest.resources;

public record AppointmentResource(
        String doctorId,
        String patientId,
        String reason,
        String appointmentDateTime
) { }
