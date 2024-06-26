package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;


public record TreatmentResource(Long id, String treatmentName, String description, String period, Long patientId) {
}
