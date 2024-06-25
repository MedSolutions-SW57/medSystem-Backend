package com.losluminosos.medsystem.profiles.domain.services;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Consultant;
import com.losluminosos.medsystem.profiles.domain.model.commands.CreateConsultantCommand;

import java.util.Optional;

public interface ConsultantCommandService {
    Optional<Consultant> handle(CreateConsultantCommand command);
}
