package com.losluminosos.medsystem.appointments.domain.model.commands;

import java.util.Date;

public record CreateAppointmentCommand(Long doctorId, Long patientId, Date date, String reason) {
}
