package com.losluminosos.medsystem.iam.interfaces.rest.resources;

import com.losluminosos.medsystem.iam.domain.model.entities.Role;

public record UserResource(Long id, String username, String role) {
}

//lo q recibo