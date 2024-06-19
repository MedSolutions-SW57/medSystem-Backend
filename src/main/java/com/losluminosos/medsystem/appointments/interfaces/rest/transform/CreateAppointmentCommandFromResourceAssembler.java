package com.losluminosos.medsystem.appointments.interfaces.rest.transform;

import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResourceAssembler {
    public static CreateAppointmentCommand toCommandFromResource(CreateAppointmentResource resource) {
        return new CreateAppointmentCommand(
                resource.doctorId(),
                resource.patientId(),
                resource.date(),
                resource.reason()
                );
    }
}
