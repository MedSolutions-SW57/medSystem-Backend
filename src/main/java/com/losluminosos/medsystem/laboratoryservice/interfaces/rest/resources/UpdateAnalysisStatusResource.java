package com.losluminosos.medsystem.laboratoryservice.interfaces.rest.resources;

import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;

public record UpdateAnalysisStatusResource(Long id, AnalysisStatus status) {
}
