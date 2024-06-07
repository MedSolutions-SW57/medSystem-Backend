package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Treatment;
import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateTreatmentCommand;
import com.losluminosos.medsystem.medicalservice.domain.model.commands.DeleteTreatmentCommand;

import java.util.Optional;

public interface TreatmentCommandService {
    Optional<Treatment> handle(CreateTreatmentCommand command);
    void handle(DeleteTreatmentCommand command);
}
