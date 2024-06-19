package com.losluminosos.medsystem.appointments.domain.services;


import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByDoctorIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByPatientIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsQuery;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    List<Appointment> handle(GetAllAppointmentsByDoctorIdQuery query);
    List<Appointment> handle(GetAllAppointmentsByPatientIdQuery query);
    //Optional<Appointment> handle(GetAppointmentByDateQuery query);
    List<Appointment> handle(GetAllAppointmentsQuery query);
}
