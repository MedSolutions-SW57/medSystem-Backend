package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateSampleCommand;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.CreateSampleResource;

public class CreateSampleCommandFromResourceAssembler {
    public static CreateSampleCommand toCommandFromResource(CreateSampleResource resource) {
        return new CreateSampleCommand(resource.type(),resource.code(),resource.patientId(),resource.doctorId(),resource.date());
    }
}
