package com.losluminosos.medsystem.profiles.domain.services;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Doctor;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetDoctorByIdQuery;

import java.util.Optional;

public interface DoctorQueryService {
    Optional<Doctor> handle(GetDoctorByIdQuery query);
}
