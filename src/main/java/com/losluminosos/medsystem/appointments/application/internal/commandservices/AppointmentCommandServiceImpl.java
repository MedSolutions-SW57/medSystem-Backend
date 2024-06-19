package com.losluminosos.medsystem.appointments.application.internal.commandservices;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.commands.DeleteAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.commands.UpdateAppointmentReasonCommand;
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
        if(appointmentRepository.existsByDate(command.date())) {
            throw new IllegalArgumentException("Appointment in date " + command.date() + " already exists");
        }
        var appointment = new Appointment(command);
        appointmentRepository.save(appointment);
        return Optional.of(appointment);
    }

    @Override
    public Optional<Appointment> handle(UpdateAppointmentReasonCommand command) {
        var result =appointmentRepository.findById(command.appointmentId());
        if(result.isEmpty()) throw new IllegalArgumentException("Appointment does not exist");
        var appointmentToUpdate = result.get();
        try {
            var updatedAppointment = appointmentRepository.save(appointmentToUpdate.updateReason(command.reason()));
            return Optional.of(updatedAppointment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating appointment: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteAppointmentCommand command) {
        var appointment = appointmentRepository.findById(command.Id());
        appointment.ifPresent(appointmentRepository::delete);
    }

}
