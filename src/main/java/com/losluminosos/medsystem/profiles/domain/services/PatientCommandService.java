package com.losluminosos.medsystem.profiles.domain.services;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Patient;
import com.losluminosos.medsystem.profiles.domain.model.commands.CreatePatientCommand;

import java.util.Optional;

public interface PatientCommandService {
    Optional<Patient> handle(CreatePatientCommand command);
}
