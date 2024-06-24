package com.losluminosos.medsystem.profiles.domain.model.commands;

public record CreateDoctorCommand(String firstName, String lastName, String email, String phone, String specialty, String licenceNumber, Long userId){}
