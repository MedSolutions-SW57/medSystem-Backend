package com.losluminosos.medsystem.profiles.interfaces.rest.transform;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Doctor;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.DoctorResource;

public class DoctorResourceFromEntityAssembler {
    public static DoctorResource toResourceFromEntity(Doctor entity) {
        return new DoctorResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getPhone(),
                entity.getSpecialty(),
                entity.getLicenseNumber()
        );
    }
}
