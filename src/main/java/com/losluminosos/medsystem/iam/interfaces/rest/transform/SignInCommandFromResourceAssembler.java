package com.losluminosos.medsystem.iam.interfaces.rest.transform;

import com.losluminosos.medsystem.iam.domain.model.commands.SignInCommand;
import com.losluminosos.medsystem.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
