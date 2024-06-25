package com.losluminosos.medsystem.profiles.interfaces.rest.transform;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Consultant;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.ConsultantResource;

public class ConsultantResourceFromEntityAssembler {
    public static ConsultantResource toResourceFromEntity(Consultant entity) {
        return new ConsultantResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getPhone(),
                entity.getLicenseNumber()
        );
    }
}
