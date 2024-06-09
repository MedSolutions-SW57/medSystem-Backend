package com.losluminosos.medsystem.medicalservice.interfaces.rest;

import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;
import com.losluminosos.medsystem.medicalservice.domain.services.ReportCommandService;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.CreateReportResource;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.ReportResource;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.transform.CreateReportCommandFromResourceAssembler;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.transform.ReportResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/reports")
@Tag(name = "Reports", description = "Report Management Endpoints")
public class ReportController {
    private final ReportCommandService reportCommandService;

    public ReportController(ReportCommandService reportCommandService) {
        this.reportCommandService = reportCommandService;
    }

    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody CreateReportResource resource) {
        Optional<Report> report = reportCommandService.handle(
                CreateReportCommandFromResourceAssembler.toCommandFromResource(resource));
        return report.map(source -> new ResponseEntity<>(
                ReportResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }
}
