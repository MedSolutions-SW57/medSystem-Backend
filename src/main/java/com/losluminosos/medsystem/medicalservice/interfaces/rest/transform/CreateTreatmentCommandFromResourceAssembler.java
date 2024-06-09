package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateTreatmentCommand;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.CreateTreatmentResource;

public class CreateTreatmentCommandFromResourceAssembler {
    public static CreateTreatmentCommand toCommandFromResource(CreateTreatmentResource resource){
        return new CreateTreatmentCommand(resource.treatmentName(), resource.description(), resource.startDate(), resource.endDate(), resource.patientId());
    }
}
