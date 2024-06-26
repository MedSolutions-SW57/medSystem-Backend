package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.TreatmentResource;

public class TreatmentResourceFromEntityAssembler {
    public static TreatmentResource toResourceFromEntity(Treatment entity){
        return new TreatmentResource(entity.getId(), entity.getTreatmentName(),entity.getDescription(),
                entity.getPeriod(), entity.getPatientId());
    }
}
