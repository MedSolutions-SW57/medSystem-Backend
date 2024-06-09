package com.losluminosos.medsystem.appointments.interfaces.rest.transform;

import com.losluminosos.medsystem.appointments.domain.model.commands.UpdateAppointmentReasonCommand;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.UpdateAppointmentReasonResource;

public class UpdateAppointmentReasonCommandFromResourceAssembler {
    public static UpdateAppointmentReasonCommand toCommandFromResource(Long appointmentId, UpdateAppointmentReasonResource resource) {
        return new UpdateAppointmentReasonCommand(appointmentId, resource.reason());
    }
}
