package com.losluminosos.medsystem.medicalservice.interfaces.rest;

import com.losluminosos.medsystem.medicalservice.domain.services.ResultQueryService;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.ResultResource;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.transform.RequestResultResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/results", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Results", description = "Results Management Endpoints")
public class ResultsController {
    private final ResultQueryService resultQueryService;

    public ResultsController(ResultQueryService resultQueryService) {
        this.resultQueryService = resultQueryService;
    }

    @GetMapping("/doctorId/{doctorId}")
    public ResponseEntity<List<ResultResource>> getResultsByDoctorId(@PathVariable String doctorId) {
        var results = resultQueryService.getByDoctorId(doctorId);
        var resources = results.stream()
                .map(RequestResultResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/patientId/{patientId}")
    public ResponseEntity<List<ResultResource>> getResultsByPatientId(@PathVariable String patientId) {
        var results = resultQueryService.getByPatientId(patientId);
        var resources = results.stream()
                .map(RequestResultResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}