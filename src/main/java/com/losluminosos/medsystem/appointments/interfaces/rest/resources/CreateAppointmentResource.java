package com.losluminosos.medsystem.appointments.interfaces.rest.resources;

import java.util.Date;

public record CreateAppointmentResource(
        Long doctorId,
        Long patientId,
        Date date,
        String reason
){ }
