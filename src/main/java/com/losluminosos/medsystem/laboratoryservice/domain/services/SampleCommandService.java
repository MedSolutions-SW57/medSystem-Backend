package com.losluminosos.medsystem.laboratoryservice.domain.services;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateSampleCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.DeleteSampleCommand;

import java.util.Optional;

public interface SampleCommandService {
    Optional<Sample> handle(CreateSampleCommand command);
    void handle(DeleteSampleCommand command);
}
