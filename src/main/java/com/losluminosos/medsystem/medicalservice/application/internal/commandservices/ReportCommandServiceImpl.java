package com.losluminosos.medsystem.medicalservice.application.internal.commandservices;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateReportCommand;
import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;
import com.losluminosos.medsystem.medicalservice.domain.services.ReportCommandService;
import com.losluminosos.medsystem.medicalservice.infrastructure.persistance.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportCommandServiceImpl implements ReportCommandService {
    private final ReportRepository reportRepository;

    public ReportCommandServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Optional<Report> handle(CreateReportCommand command) {
        if (reportRepository.existsByDateAndReason(command.date(), command.reason())){
            throw new IllegalArgumentException("Report already exists");
        }
        var report = new Report(command);
        var createdReport = reportRepository.save(report);
        return Optional.of(createdReport);
    }
}
