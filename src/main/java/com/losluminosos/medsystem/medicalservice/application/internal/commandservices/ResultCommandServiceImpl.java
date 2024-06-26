package com.losluminosos.medsystem.medicalservice.application.internal.commandservices;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;
import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateResultCommand;
import com.losluminosos.medsystem.medicalservice.domain.services.ResultCommandService;
import com.losluminosos.medsystem.medicalservice.infrastructure.persistence.jpa.repositories.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultCommandServiceImpl implements ResultCommandService {
    private final ResultRepository resultRepository;

    public ResultCommandServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Optional<Result> handle(CreateResultCommand command) {
        var result  = new Result(command);
        resultRepository.save(result);
        return Optional.of(result);
    }
}
