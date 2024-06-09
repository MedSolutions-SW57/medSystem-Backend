package com.losluminosos.medsystem.medicalservice.application.internal.commandservices;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.History;
import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateHistoryCommand;
import com.losluminosos.medsystem.medicalservice.domain.services.HistoryCommandService;
import com.losluminosos.medsystem.medicalservice.infrastructure.persistance.jpa.repositories.HistoryRepository;

import java.util.Optional;

public class HistoryCommandServiceImpl implements HistoryCommandService {
    private final HistoryRepository historyRepository;

    public HistoryCommandServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    @Override
    public Optional<History> handle(CreateHistoryCommand command) {
        if (historyRepository.existsByPatientId(command.patientId())){
            throw new IllegalArgumentException("History already exists with same patientId");
        }
        var history = new History(command);
        var createdHistory = historyRepository.save(history);
        return Optional.of(createdHistory);
    }
}
