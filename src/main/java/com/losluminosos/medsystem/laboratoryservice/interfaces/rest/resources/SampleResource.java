package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record SampleResource(
        Long id,
        String type,
        String code,
        Long patientId,
        Long doctorId,
        String date
) {
}
