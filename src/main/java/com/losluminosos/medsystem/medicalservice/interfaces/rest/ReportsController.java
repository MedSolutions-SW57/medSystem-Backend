package com.losluminosos.medsystem.medicalservice.interfaces.rest;

import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetAllReportsQuery;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetReportByIdQuery;
import com.losluminosos.medsystem.medicalservice.domain.model.queries.GetReportsByPatientIdQuery;
import com.losluminosos.medsystem.medicalservice.domain.services.ReportCommandService;
import com.losluminosos.medsystem.medicalservice.domain.services.ReportQueryService;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.CreateReportResource;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.ReportResource;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.transform.CreateReportCommandFromResourceAssembler;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.transform.ReportResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/reports")
@Tag(name = "Reports", description = "Report Management Endpoints")
public class ReportsController {
    private final ReportCommandService reportCommandService;
    private final ReportQueryService reportQueryService;

    public ReportsController(ReportCommandService reportCommandService, ReportQueryService reportQueryService) {
        this.reportCommandService = reportCommandService;
        this.reportQueryService = reportQueryService;
    }

    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody CreateReportResource resource) {
        Optional<Report> report = reportCommandService.handle(
                CreateReportCommandFromResourceAssembler.toCommandFromResource(resource));
        return report.map(source -> new ResponseEntity<>(
                ReportResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResource> getReportById(@PathVariable Long id) {
        var getReportByIdQuery = new GetReportByIdQuery(id);
        Optional<Report> report = reportQueryService.handle(getReportByIdQuery);
        if (report.isEmpty()) return ResponseEntity.notFound().build();
        return report.map(source -> ResponseEntity.ok(ReportResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("patientId/{patientId}")
    public ResponseEntity<List<ReportResource>> getAllReportsByPatientId(@PathVariable Long patientId) {
        var getReportsByPatientIdQuery = new GetReportsByPatientIdQuery(patientId);
        List<Report> reports = reportQueryService.handle(getReportsByPatientIdQuery);
        if (reports.isEmpty()) return ResponseEntity.notFound().build();
        var reportsResources =reports.stream().map(ReportResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reportsResources);
    }

    @GetMapping
    public ResponseEntity<List<ReportResource>> getAllReports() {
        var getAllReportsQuery = new GetAllReportsQuery();
        List<Report> reports = reportQueryService.handle(getAllReportsQuery);
        if (reports.isEmpty()) return ResponseEntity.notFound().build();
        var reportsResources =reports.stream().map(ReportResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reportsResources);
    }
}
