package com.losluminosos.medsystem.profiles.interfaces.rest.resources;

public record CreateDoctorResource(
        String firstName,
        String lastName,
        String email,
        String phone,
        String specialty,
        String licenceNumber,
        Long userId
) {}
