package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record ResultResource(
        String idResult,
        String doctorId,
        String patientId,
        String typeOfExam,
        String ResultDateTime,
        boolean result
) { }