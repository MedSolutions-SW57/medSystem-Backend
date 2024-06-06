package com.losluminosos.medsystem.appointments.interfaces.rest.transform;

import com.losluminosos.medsystem.appointments.domain.model.commands.DeleteAppointmentCommand;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.DeleteAppointmentResource;

public class DeleteAppointmentCommandFromResourceAssembler {
    public static DeleteAppointmentCommand toCommandFromResource(DeleteAppointmentResource resource) {
        return new DeleteAppointmentCommand(resource.id());
    }
}
