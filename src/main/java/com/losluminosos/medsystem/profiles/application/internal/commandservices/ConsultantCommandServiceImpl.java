package com.losluminosos.medsystem.profiles.application.internal.commandservices;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Consultant;
import com.losluminosos.medsystem.profiles.domain.model.commands.CreateConsultantCommand;
import com.losluminosos.medsystem.profiles.domain.services.ConsultantCommandService;
import com.losluminosos.medsystem.profiles.infrastructure.persistence.jpa.repositories.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultantCommandServiceImpl implements ConsultantCommandService {
    private final ConsultantRepository consultantRepository;

    public ConsultantCommandServiceImpl(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @Override
    public Optional<Consultant> handle(CreateConsultantCommand command) {
        var consultant = new Consultant(command);
        consultantRepository.save(consultant);
        return Optional.of(consultant);
    }
}
