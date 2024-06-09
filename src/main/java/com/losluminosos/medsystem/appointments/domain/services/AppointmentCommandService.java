package com.losluminosos.medsystem.appointments.domain.services;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.commands.DeleteAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.commands.UpdateAppointmentReasonCommand;

import java.util.Optional;

public interface AppointmentCommandService {
    Optional<Appointment> handle(CreateAppointmentCommand command);
    Optional<Appointment> handle(UpdateAppointmentReasonCommand command);
    void handle(DeleteAppointmentCommand command);
}
