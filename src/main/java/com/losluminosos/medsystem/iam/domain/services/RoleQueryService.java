package com.losluminosos.medsystem.iam.domain.services;

import com.losluminosos.medsystem.iam.domain.model.entities.Role;
import com.losluminosos.medsystem.iam.domain.model.queries.GetAllRolesQuery;
import com.losluminosos.medsystem.iam.domain.model.queries.GetRoleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByIdQuery query);
}
