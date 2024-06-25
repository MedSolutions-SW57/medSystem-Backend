package com.losluminosos.medsystem.profiles.domain.services;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Consultant;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetConsultantByIdQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetConsultantByUserIdQuery;

import java.util.Optional;

public interface ConsultantQueryService {
    Optional<Consultant> handle(GetConsultantByIdQuery query);
    Optional<Consultant> handle(GetConsultantByUserIdQuery query);
}
