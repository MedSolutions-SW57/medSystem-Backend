package com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates;

import com.losluminosos.medsystem.laboratoryservice.domain.model.entities.AnalysisStatus;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Analysis extends AuditableAbstractAggregateRoot<Analysis>{

    @NotBlank(message = "Analysis type cannot be empty")
    private String analysisType;

    @NotBlank(message = "Sample id cannot be empty")
    private String sampleId;

    @NotNull(message = "Patient dni cannot be empty")
    private Long patientId;

    @NotBlank(message = "Date cannot be empty")
    private String Date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private AnalysisStatus status;

    public Analysis() {}

    public Analysis(String analysisType, String sampleId, Long patientId, String Date, AnalysisStatus status) {
        this();
        this.analysisType = analysisType;
        this.sampleId = sampleId;
        this.patientId = patientId;
        this.Date = Date;
        this.status = status;
    }

    public Analysis updateStatus(AnalysisStatus status) {
        this.status = status;
        return this;
    }
}
