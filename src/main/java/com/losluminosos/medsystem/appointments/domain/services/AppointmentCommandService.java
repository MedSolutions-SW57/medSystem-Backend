package com.losluminosos.medsystem.appointments.domain.services;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.commands.DeleteAppointmentCommand;

import java.util.Optional;

public interface AppointmentCommandService {
    Optional<Appointment> handle(CreateAppointmentCommand command);
    void handle(DeleteAppointmentCommand command);
}
