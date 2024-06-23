package com.losluminosos.medsystem.profiles.interfaces.rest;

import com.losluminosos.medsystem.profiles.domain.services.PatientCommandService;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.CreatePatientResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.PatientResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.CreatePatientCommandFromResourceAssembler;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.PatientResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Patients", description = "Patient Management Endpoints")
public class PatientsController {
    private final PatientCommandService patientCommandService;

    public PatientsController(PatientCommandService patientCommandService) {
        this.patientCommandService = patientCommandService;
    }

    @PostMapping
    public ResponseEntity<PatientResource> createPatient(@RequestBody CreatePatientResource resource) {
        var createPatientCommand = CreatePatientCommandFromResourceAssembler.toCommandFromResource(resource);
        var patient = patientCommandService.handle(createPatientCommand);
        if (patient.isEmpty()) return ResponseEntity.badRequest().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return new ResponseEntity<>(patientResource, HttpStatus.CREATED);
    }
}
