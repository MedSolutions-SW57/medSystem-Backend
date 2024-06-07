package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

import com.losluminosos.medsystem.medicalservice.domain.model.valueobjects.Period;

public record TreatmentResource(String treatmentName, String description, String period) {
}
