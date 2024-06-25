package com.losluminosos.medsystem.laboratoryservice.interfaces.rest;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.DeleteSampleCommand;
import com.losluminosos.medsystem.laboratoryservice.domain.model.queries.GetAllSamplesQuery;
import com.losluminosos.medsystem.laboratoryservice.domain.services.SampleCommandService;
import com.losluminosos.medsystem.laboratoryservice.domain.services.SampleQueryService;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.CreateSampleResource;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources.SampleResource;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform.CreateSampleCommandFromResourceAssembler;
import com.losluminosos.medsystem.laboratoryservice.interfaces.rest.transform.SampleResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/samples", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Samples", description = "Samples Management Endpoints")
public class SamplesController {
    private final SampleCommandService sampleCommandService;
    private final SampleQueryService sampleQueryService;

    public SamplesController(SampleCommandService sampleCommandService, SampleQueryService sampleQueryService) {
        this.sampleCommandService = sampleCommandService;
        this.sampleQueryService = sampleQueryService;
    }

    @PostMapping
    public ResponseEntity<SampleResource> createSample(@RequestBody CreateSampleResource resource) {
        var createSampleCommand = CreateSampleCommandFromResourceAssembler.toCommandFromResource(resource);
        var sample = sampleCommandService.handle(createSampleCommand);
        if(sample.isEmpty()) return ResponseEntity.badRequest().build();
        var sampleResource = SampleResourceFromEntityAssembler.toResourceFromEntity(sample.get());
        return new ResponseEntity<>(sampleResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SampleResource>> getAllSamples() {
        var getAllSamplesQuery = new GetAllSamplesQuery();
        var samples = sampleQueryService.handle(getAllSamplesQuery);
        var sampleResource = samples.stream().map(SampleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(sampleResource);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteSample(@PathVariable String code) {
        var deleteSampleCommand = new DeleteSampleCommand(code);
        sampleCommandService.handle(deleteSampleCommand);
        return ResponseEntity.ok("Code successfully removed");
    }
}
