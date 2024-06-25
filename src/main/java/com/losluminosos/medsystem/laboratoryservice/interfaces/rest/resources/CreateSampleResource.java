package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

public record CreateSampleResource(
        String type,
        String code,
        Long patientId,
        Long doctorId,
        String date
) {
}
