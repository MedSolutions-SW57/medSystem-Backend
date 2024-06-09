package com.losluminosos.medsystem.medicalservice.domain.services;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateReportCommand;
import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;

import java.util.Optional;

public interface ReportCommandService {
    Optional<Report> handle(CreateReportCommand command);
}
