package com.losluminosos.medsystem.iam.interfaces.rest.transform;

import com.losluminosos.medsystem.iam.domain.model.aggregates.User;
import com.losluminosos.medsystem.iam.domain.model.entities.Role;
import com.losluminosos.medsystem.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getUsername(),
                entity.getRole().getStringName());
    }
}
