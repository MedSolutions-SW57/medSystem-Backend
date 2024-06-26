package com.losluminosos.medsystem.profiles.interfaces.rest;

import com.losluminosos.medsystem.profiles.domain.model.queries.GetAllDoctorsQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetDoctorByIdQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetDoctorByUserIdQuery;
import com.losluminosos.medsystem.profiles.domain.services.DoctorCommandService;
import com.losluminosos.medsystem.profiles.domain.services.DoctorQueryService;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.CreateDoctorResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.DoctorResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.CreateDoctorCommandFromResourceAssembler;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.DoctorResourceFromEntityAssembler;
import io.swagger.v3.core.util.ApiResponsesDeserializer;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Doctors", description = "Doctor Management Endpoints")
public class DoctorsController {
    private final DoctorQueryService doctorQueryService;
    private final DoctorCommandService doctorCommandService;

    public DoctorsController(DoctorQueryService doctorQueryService, DoctorCommandService doctorCommandService) {
        this.doctorQueryService = doctorQueryService;
        this.doctorCommandService = doctorCommandService;
    }

    @PostMapping
    public ResponseEntity<DoctorResource> createDoctor(@RequestBody CreateDoctorResource resource) {
        var createDoctorCommand = CreateDoctorCommandFromResourceAssembler.toCommandFromResource(resource);
        var doctor = doctorCommandService.handle(createDoctorCommand);
        if (doctor.isEmpty()) return ResponseEntity.badRequest().build();
        var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(doctor.get());
        return new ResponseEntity<>(doctorResource, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<DoctorResource>> getAllDoctors(){
        var getAllDoctorsQuery = new GetAllDoctorsQuery();
        var doctors = doctorQueryService.handle(getAllDoctorsQuery);
        var doctorResources = doctors.stream().map(DoctorResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(doctorResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResource> getDoctorById(@PathVariable Long id) {
        var getDoctorByIdQuery = new GetDoctorByIdQuery(id);
        var doctor = doctorQueryService.handle(getDoctorByIdQuery);
        if (doctor.isEmpty())
            return ResponseEntity.notFound().build();
        var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(doctor.get());
        return ResponseEntity.ok(doctorResource);
    }

    @GetMapping("userId/{id}")
    public ResponseEntity<DoctorResource> getDoctorByUserId(@PathVariable Long id) {
        var getDoctorByUserIdQuery = new GetDoctorByUserIdQuery(id);
        var doctor = doctorQueryService.handle(getDoctorByUserIdQuery);
        if (doctor.isEmpty())
            return ResponseEntity.notFound().build();
        var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(doctor.get());
        return ResponseEntity.ok(doctorResource);
    }
}
