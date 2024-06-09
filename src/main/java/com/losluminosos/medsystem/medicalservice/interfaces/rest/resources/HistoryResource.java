package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record HistoryResource(Long id, String reason, String date,  String patientId, String doctorId) {
}
