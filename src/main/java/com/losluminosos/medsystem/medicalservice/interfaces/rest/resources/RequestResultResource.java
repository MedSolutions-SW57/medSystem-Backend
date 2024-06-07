package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record RequestResultResource(
        String idResult,
        String doctorId,
        String patientId,
        String typeOfExam,
        String requestResultDateTime,
        boolean result
) { }