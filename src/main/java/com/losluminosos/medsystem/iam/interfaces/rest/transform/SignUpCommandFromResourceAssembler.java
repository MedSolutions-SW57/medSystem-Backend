package com.losluminosos.medsystem.iam.interfaces.rest.transform;

import com.losluminosos.medsystem.iam.domain.model.commands.SignUpCommand;
import com.losluminosos.medsystem.iam.domain.model.entities.Role;
import com.losluminosos.medsystem.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null
                ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList()
                : new ArrayList<Role>();
        System.out.print("Roles:");
        System.out.println(roles.getFirst().getName().name());
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
