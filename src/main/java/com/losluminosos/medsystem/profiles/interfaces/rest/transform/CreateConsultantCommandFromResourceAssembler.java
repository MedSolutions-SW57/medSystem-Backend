package com.losluminosos.medsystem.profiles.interfaces.rest.transform;

import com.losluminosos.medsystem.profiles.domain.model.commands.CreateConsultantCommand;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.CreateConsultantResource;

public class CreateConsultantCommandFromResourceAssembler {
    public static CreateConsultantCommand toCommandFromResource(CreateConsultantResource resource) {
        return new CreateConsultantCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.phone(),
                resource.licenceNumber(),
                resource.userId()
        );
    }
}
