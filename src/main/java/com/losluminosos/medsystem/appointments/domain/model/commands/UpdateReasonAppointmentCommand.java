package com.losluminosos.medsystem.appointments.domain.model.commands;

public record UpdateReasonAppointmentCommand(Long appointmentId, String reason) {
}
