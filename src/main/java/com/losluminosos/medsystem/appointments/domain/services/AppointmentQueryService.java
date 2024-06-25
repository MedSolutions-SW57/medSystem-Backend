package com.losluminosos.medsystem.appointments.domain.services;


import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByDoctorIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByPatientIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAppointmentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    Optional<Appointment> handle(GetAppointmentByIdQuery query);
    List<Appointment> handle(GetAllAppointmentsByDoctorIdQuery query);
    List<Appointment> handle(GetAllAppointmentsByPatientIdQuery query);
    List<Appointment> handle(GetAllAppointmentsQuery query);
}
