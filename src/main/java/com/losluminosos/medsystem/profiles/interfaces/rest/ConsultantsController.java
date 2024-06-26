package com.losluminosos.medsystem.profiles.interfaces.rest;

import com.losluminosos.medsystem.profiles.domain.model.queries.GetAllConsultantsQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetConsultantByIdQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetConsultantByUserIdQuery;
import com.losluminosos.medsystem.profiles.domain.services.ConsultantCommandService;
import com.losluminosos.medsystem.profiles.domain.services.ConsultantQueryService;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.CreateConsultantResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.resources.ConsultantResource;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.CreateConsultantCommandFromResourceAssembler;
import com.losluminosos.medsystem.profiles.interfaces.rest.transform.ConsultantResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/consultants", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Consultants", description = "Consultant Management Endpoints")
public class ConsultantsController {
    private final ConsultantQueryService consultantQueryService;
    private final ConsultantCommandService consultantCommandService;

    public ConsultantsController(ConsultantQueryService consultantQueryService, ConsultantCommandService consultantCommandService) {
        this.consultantQueryService = consultantQueryService;
        this.consultantCommandService = consultantCommandService;
    }

    @PostMapping
    public ResponseEntity<ConsultantResource> createConsultant(@RequestBody CreateConsultantResource resource) {
        var createConsultantCommand = CreateConsultantCommandFromResourceAssembler.toCommandFromResource(resource);
        var consultant = consultantCommandService.handle(createConsultantCommand);
        if (consultant.isEmpty()) return ResponseEntity.badRequest().build();
        var consultantResource = ConsultantResourceFromEntityAssembler.toResourceFromEntity(consultant.get());
        return new ResponseEntity<>(consultantResource, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ConsultantResource>> getAllConsultants(){
        var getAllConsultantsQuery = new GetAllConsultantsQuery();
        var consultants = consultantQueryService.handle(getAllConsultantsQuery);
        var consultantResources = consultants.stream().map(ConsultantResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(consultantResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultantResource> getConsultantById(@PathVariable Long id) {
        var getConsultantByIdQuery = new GetConsultantByIdQuery(id);
        var consultant = consultantQueryService.handle(getConsultantByIdQuery);
        if (consultant.isEmpty())
            return ResponseEntity.notFound().build();
        var consultantResource = ConsultantResourceFromEntityAssembler.toResourceFromEntity(consultant.get());
        return ResponseEntity.ok(consultantResource);
    }

    @GetMapping("userId/{id}")
    public ResponseEntity<ConsultantResource> getConsultantByUserId(@PathVariable Long id) {
        var getConsultantByUserIdQuery = new GetConsultantByUserIdQuery(id);
        var consultant = consultantQueryService.handle(getConsultantByUserIdQuery);
        if (consultant.isEmpty())
            return ResponseEntity.notFound().build();
        var consultantResource = ConsultantResourceFromEntityAssembler.toResourceFromEntity(consultant.get());
        return ResponseEntity.ok(consultantResource);
    }
}
