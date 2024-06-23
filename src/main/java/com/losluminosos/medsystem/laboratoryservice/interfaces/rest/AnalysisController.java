package com.losluminosos.medsystem.laboratoryservice.interfaces.rest;

import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllAnalysisQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.services.AnalysisCommandService;
import com.losluminosos.medsystem.laboratoryservice.domain.services.AnalysisQueryService;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.AnalysisResource;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.CreateAnalysisResource;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.UpdateAnalysisStatusResource;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform.AnalysisResourceFromEntityAssembler;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform.CreateAnalysisCommandFromResourceAssembler;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform.UpdateAnalysisStatusCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/analysis", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Analysis", description = "Analysis Management Endpoints")
public class AnalysisController {
    private final AnalysisCommandService analysisCommandService;
    private final AnalysisQueryService analysisQueryService;

    public AnalysisController(AnalysisCommandService analysisCommandService, AnalysisQueryService analysisQueryService) {
        this.analysisCommandService = analysisCommandService;
        this.analysisQueryService = analysisQueryService;
    }

    @PostMapping
    public ResponseEntity<AnalysisResource> createAnalysis(@RequestBody CreateAnalysisResource resource){
        var createAnalysisCommand = CreateAnalysisCommandFromResourceAssembler.toCommandFromResource(resource);
        var analysis = analysisCommandService.handle(createAnalysisCommand);
        if(analysis.isEmpty()) return ResponseEntity.badRequest().build();
        var analysisResource = AnalysisResourceFromEntityAssembler.toResourceFromEntity(analysis.get());
        return new ResponseEntity<>(analysisResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnalysisResource>> getAllAnalysis(){
        var getAllAnalysisQuery = new GetAllAnalysisQuery();
        var analysis = analysisQueryService.handle(getAllAnalysisQuery);
        var analysisResources = analysis.stream()
                .map(AnalysisResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(analysisResources);
    }

    @PutMapping
    public ResponseEntity<AnalysisResource> updateAnalysis(@RequestBody UpdateAnalysisStatusResource resource){
        var updateAnalysisCommand = UpdateAnalysisStatusCommandFromResourceAssembler.toCommandFromResource(resource.id(), resource);
        var updatedAnalysis = analysisCommandService.handle(updateAnalysisCommand);
        if(updatedAnalysis.isEmpty()) return ResponseEntity.badRequest().build();
        var analysisResource = AnalysisResourceFromEntityAssembler.toResourceFromEntity(updatedAnalysis.get());
        return new ResponseEntity<>(analysisResource, HttpStatus.OK);
    }
}
