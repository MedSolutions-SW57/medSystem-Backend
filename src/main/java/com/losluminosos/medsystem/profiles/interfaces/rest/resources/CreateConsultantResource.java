package com.losluminosos.medsystem.profiles.interfaces.rest.resources;

public record CreateConsultantResource(
        String firstName,
        String lastName,
        String email,
        String phone,
        String licenceNumber,
        Long userId
) {
}
