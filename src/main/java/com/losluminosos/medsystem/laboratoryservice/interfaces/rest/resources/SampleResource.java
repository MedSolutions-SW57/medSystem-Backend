package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record SampleResource(
        Long id,
        String type,
        String code,
        String patientDni,
        Long doctorId,
        String date
) {
}
