package com.losluminosos.medsystem.medicalservice.interfaces.rest;

import com.losluminosos.medsystem.medicalservice.domain.services.RequestResultQueryService;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.RequestResultResource;
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
@RequestMapping(value = "/api/v1/request-results", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Request Results", description = "Request Results Management Endpoints")
public class RequestResultController {
    private final RequestResultQueryService requestResultQueryService;

    public RequestResultController(RequestResultQueryService requestResultQueryService) {
        this.requestResultQueryService = requestResultQueryService;
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<RequestResultResource>> getRequestResultsByDoctorId(@PathVariable String doctorId) {
        var results = requestResultQueryService.getByDoctorId(doctorId);
        var resources = results.stream()
                .map(RequestResultResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<RequestResultResource>> getRequestResultsByPatientId(@PathVariable String patientId) {
        var results = requestResultQueryService.getByPatientId(patientId);
        var resources = results.stream()
                .map(RequestResultResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}