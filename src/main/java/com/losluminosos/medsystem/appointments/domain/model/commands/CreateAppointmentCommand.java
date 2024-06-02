package com.losluminosos.medsystem.appointments.domain.model.commands;

public record CreateAppointmentCommand(String doctorId, String patientId, String reason, String appointmentDate, String appointmentTime) {
}
