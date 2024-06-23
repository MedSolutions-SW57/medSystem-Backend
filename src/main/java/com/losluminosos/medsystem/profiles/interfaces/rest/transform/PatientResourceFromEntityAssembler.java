package com.losluminosos.medsystem.profiles.interfaces.rest.transform;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Patient;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.PatientResource;

public class PatientResourceFromEntityAssembler {
    public static PatientResource toResourceFromEntity(Patient entity) {
        return new PatientResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getPhone(),
                entity.getStreetAddress()
        );
    }
}
