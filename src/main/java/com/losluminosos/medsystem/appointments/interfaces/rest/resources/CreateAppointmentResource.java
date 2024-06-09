package com.losluminosos.medsystem.appointments.interfaces.rest.resources;

public record CreateAppointmentResource(
        String doctorId,
        String patientId,
        String reason,
        String date,
        String time
){ }
