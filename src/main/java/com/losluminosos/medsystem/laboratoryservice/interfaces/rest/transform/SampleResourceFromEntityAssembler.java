package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.SampleResource;

public class SampleResourceFromEntityAssembler {
    public static SampleResource toResourceFromEntity(Sample entity){
        return new SampleResource(entity.getId(),entity.getType(),entity.getCode(),
                entity.getPatientId(),entity.getDoctorId(),entity.getDate());
    }
}
