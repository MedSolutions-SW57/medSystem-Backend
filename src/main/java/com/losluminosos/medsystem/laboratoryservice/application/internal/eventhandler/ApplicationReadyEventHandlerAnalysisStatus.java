package com.losluminosos.medsystem.laboratoryservice.application.internal.eventhandler;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.SeedAnalysisStatusCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.services.AnalysisStatusCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class ApplicationReadyEventHandlerAnalysisStatus {
    private final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandlerAnalysisStatus.class);
    private final AnalysisStatusCommandService analysisStatusCommandService;

    public ApplicationReadyEventHandlerAnalysisStatus(AnalysisStatusCommandService analysisStatusCommandService) {
        this.analysisStatusCommandService = analysisStatusCommandService;
    }

    private Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    @EventListener
    public void on(ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if analysis status seeding is needed for {} at {}", applicationName, getCurrentTimestamp());
        var seedAnalysisStatusCommand = new SeedAnalysisStatusCommand();
        analysisStatusCommandService.handle(seedAnalysisStatusCommand);
        LOGGER.info("Analysis status seeding verification finished for {} at {}", applicationName, getCurrentTimestamp());
    }
}
