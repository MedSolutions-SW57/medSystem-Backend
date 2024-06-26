package com.losluminosos.medsystem.profiles.interfaces.rest;

import com.losluminosos.medsystem.profiles.domain.model.queries.GetAllPatientsQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetPatientByIdQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetPatientByUserIdQuery;
import com.losluminosos.medsystem.profiles.domain.services.PatientCommandService;
import com.losluminosos.medsystem.profiles.domain.services.PatientQueryService;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.CreatePatientResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.PatientResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.CreatePatientCommandFromResourceAssembler;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.PatientResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Patients", description = "Patient Management Endpoints")
public class PatientsController {
    private final PatientQueryService patientQueryService;
    private final PatientCommandService patientCommandService;

    public PatientsController(PatientQueryService patientQueryService, PatientCommandService patientCommandService) {
        this.patientQueryService = patientQueryService;
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

    @GetMapping
    public ResponseEntity<List<PatientResource>> getAllPatients(){
        var getAllPatientsQuery = new GetAllPatientsQuery();
        var patients = patientQueryService.handle(getAllPatientsQuery);
        var patientResources = patients.stream().map(PatientResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(patientResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResource> getPatientById(@PathVariable Long id) {
        var getPatientByIdQuery = new GetPatientByIdQuery(id);
        var patient = patientQueryService.handle(getPatientByIdQuery);
        if (patient.isEmpty())
            return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }

    @GetMapping("userId/{id}")
    public ResponseEntity<PatientResource> getPatientByUserId(@PathVariable Long id) {
        var getPatientByUserIdQuery = new GetPatientByUserIdQuery(id);
        var patient = patientQueryService.handle(getPatientByUserIdQuery);
        if (patient.isEmpty())
            return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }
}
