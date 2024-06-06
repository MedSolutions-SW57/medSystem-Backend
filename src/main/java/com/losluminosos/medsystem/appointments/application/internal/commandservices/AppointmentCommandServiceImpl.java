package com.losluminosos.medsystem.appointments.application.internal.commandservices;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.commands.DeleteAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.services.AppointmentCommandService;
import com.losluminosos.medsystem.appointments.infrastructure.persistance.jpa.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentCommandServiceImpl implements AppointmentCommandService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentCommandServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> handle(CreateAppointmentCommand command) {

        if(appointmentRepository.existsByAppointmentDateTime_AppointmentDateAndAppointmentDateTime_AppointmentTime(command.appointmentDate(), command.appointmentTime())){
            throw new IllegalArgumentException("Appointment with date and time " + command.appointmentDate() + " already exists");
        }
        var appointment = new Appointment(command);
        appointmentRepository.save(appointment);
        return Optional.of(appointment);
    }

    @Override
    public void handle(DeleteAppointmentCommand command) {
        var appointment = appointmentRepository.findById(command.Id());
        appointment.ifPresent(appointmentRepository::delete);
    }

}
