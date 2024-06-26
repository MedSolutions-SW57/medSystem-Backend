package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateReportCommand;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.CreateReportResource;

public class CreateReportCommandFromResourceAssembler {
    public static CreateReportCommand toCommandFromResource(CreateReportResource resource) {
        return new CreateReportCommand(resource.reason(), resource.date(), resource.patientId());
    }
}
