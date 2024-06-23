package com.losluminosos.medsystem.iam.domain.model.commands;

import com.losluminosos.medsystem.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, Role role) {
}
