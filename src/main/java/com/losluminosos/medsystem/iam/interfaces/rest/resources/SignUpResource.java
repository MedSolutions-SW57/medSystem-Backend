package com.losluminosos.medsystem.iam.interfaces.rest.resources;


import com.losluminosos.medsystem.iam.domain.model.entities.Role;

public record SignUpResource(String username, String password, String role) {
}

//lo q escribo