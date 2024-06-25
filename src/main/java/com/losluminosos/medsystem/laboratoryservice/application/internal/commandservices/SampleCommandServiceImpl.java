package com.losluminosos.medsystem.laboratoryservice.application.internal.commandservices;

import com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates.Sample;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateSampleCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.DeleteSampleCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.services.SampleCommandService;
import com.losluminosos.medsystem.laboratoryservice.infrastructure.persistence.jpa.repositories.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SampleCommandServiceImpl implements SampleCommandService {
    private final SampleRepository sampleRepository;

    public SampleCommandServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Optional<Sample> handle(CreateSampleCommand command) {
        if(sampleRepository.existsByCode(command.code())){
            throw new IllegalArgumentException("Sample with that code already exists");
        }
        var sample = new Sample(command);
        var createdSample = sampleRepository.save(sample);
        return Optional.of(createdSample);
    }

    @Override
    public void handle(DeleteSampleCommand command) {
        var sample = sampleRepository.findSampleByCode(command.code());
        sample.ifPresent(sampleRepository::delete);
    }
}
