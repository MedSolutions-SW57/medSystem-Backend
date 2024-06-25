package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

public record CreateSampleCommand(String type, String code, String patientDni, Long doctorId, String date) {
}
