package com.losluminosos.medsystem.profiles.interfaces.rest.resources;

public record DoctorResource(Long id, String fullName, String email, String phone, String specialty, String licenseNumber) {}
