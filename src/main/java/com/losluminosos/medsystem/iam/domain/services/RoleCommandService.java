package com.losluminosos.medsystem.iam.domain.services;

import com.losluminosos.medsystem.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
