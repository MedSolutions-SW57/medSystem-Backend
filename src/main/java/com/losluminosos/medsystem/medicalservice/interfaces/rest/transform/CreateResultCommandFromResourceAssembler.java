package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateResultCommand;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.CreateResultResource;

public class CreateResultCommandFromResourceAssembler {
    public static CreateResultCommand toCommandFromResource(CreateResultResource resource) {
        return new CreateResultCommand(resource.doctorId(), resource.patientId(), resource.typeOfExam(),
                resource.resultDateTime(), resource.result());
    }
}
