package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.History;
import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateHistoryCommand;

import java.util.Optional;

public interface HistoryCommandService {
    Optional<History> handle(CreateHistoryCommand command);
}
