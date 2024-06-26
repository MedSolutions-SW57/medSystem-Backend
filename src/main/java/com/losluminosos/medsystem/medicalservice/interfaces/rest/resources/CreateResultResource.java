package com.losluminosos.medsystem.medicalservice.interfaces.rest.resources;

public record CreateResultResource(Long doctorId, Long patientId, String typeOfExam, String resultDateTime, boolean result) {
}
