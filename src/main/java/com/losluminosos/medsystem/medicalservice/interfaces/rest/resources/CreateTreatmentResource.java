package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record CreateTreatmentResource(String treatmentName, String description, String startDate, String endDate, String patientId) {
}
