package com.losluminosos.medsystem.appointments.domain.model.commands;

public record UpdateAppointmentReasonCommand(Long appointmentId, String reason) {
}
