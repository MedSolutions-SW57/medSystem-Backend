package com.losluminosos.medsystem.appointments.application.internal.queryservices;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByDoctorIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByPatientIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAppointmentByIdQuery;
import com.losluminosos.medsystem.appointments.domain.services.AppointmentQueryService;
import com.losluminosos.medsystem.appointments.infrastructure.persistance.jpa.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentQueryServiceImpl implements AppointmentQueryService{
    private final AppointmentRepository appointmentRepository;

    public AppointmentQueryServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> handle(GetAllAppointmentsByPatientIdQuery query){
        return appointmentRepository.findAllByPatientId(query.patientId());
    }

    @Override
    public Optional<Appointment> handle(GetAppointmentByIdQuery query) {
        return appointmentRepository.findById(query.id());
    }

    @Override
    public List<Appointment> handle(GetAllAppointmentsByDoctorIdQuery query){
        return appointmentRepository.findAllByDoctorId(query.doctorId());
    }


    @Override
    public List<Appointment> handle(GetAllAppointmentsQuery query){
        return appointmentRepository.findAll();
    }
}
