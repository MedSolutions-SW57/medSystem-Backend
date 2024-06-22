package com.losluminosos.medsystem.iam.interfaces.rest.transform;

import com.losluminosos.medsystem.iam.domain.model.commands.SignUpCommand;
import com.losluminosos.medsystem.iam.domain.model.entities.Role;
import com.losluminosos.medsystem.iam.domain.model.valueobjects.Roles;
import com.losluminosos.medsystem.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var erole = new Role(Roles.valueOf(resource.role()));
        return new SignUpCommand(resource.username(), resource.password(), erole);
    }
}
