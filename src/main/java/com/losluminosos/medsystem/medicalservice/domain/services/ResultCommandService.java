package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;
import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateResultCommand;

import java.util.Optional;

public interface ResultCommandService {
    Optional<Result> handle(CreateResultCommand command);
}
