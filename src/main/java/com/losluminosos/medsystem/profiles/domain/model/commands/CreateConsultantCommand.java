package com.losluminosos.medsystem.profiles.domain.model.commands;

public record CreateConsultantCommand(String firstName, String lastName, String email, String phone, String licenceNumber, Long userId) {
}
