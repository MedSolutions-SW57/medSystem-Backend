package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record CreateSampleResource(
        String type,
        String code,
        String patientDni,
        Long doctorId, 
        String date
) {
}
