package com.losluminosos.medsystem.appointments.interfaces.rest.transform;

import com.losluminosos.medsystem.appointments.domain.model.aggregates.Appointment;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.AppointmentResource;

public class AppointmentResourceFromEntityAssembler {
    public static AppointmentResource toResourceFromEntity(Appointment appointment) {
        return new AppointmentResource(
                appointment.getDoctorId(),
                appointment.getPatientId(),
                appointment.getReason(),
                appointment.getAppointmentDateTime());
    }
}
