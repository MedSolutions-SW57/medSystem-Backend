package com.losluminosos.medsystem.laboratoryservice.domain.model.commands;

public record CreateSampleCommand(String type, String code, Long patientId, Long doctorId, String date) {
}
