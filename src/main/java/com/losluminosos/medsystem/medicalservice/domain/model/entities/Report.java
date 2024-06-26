package com.losluminosos.medsystem.medicalservice.domain.model.entities;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateReportCommand;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Report extends AuditableAbstractAggregateRoot<Report> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "reason", nullable = false)
    @Getter
    private String reason;

    @Column(name = "date", nullable = false, updatable = false)
    @Getter
    private String date;

    @Column(name = "patient_id", nullable = false, updatable = false)
    @Getter
    private Long patientId;

    protected Report() {}

    public Report(String reason, String date, Long patientId) {
        this.reason = reason;
        this.date = date;
        this.patientId = patientId;
    }

    public Report(CreateReportCommand command) {
        this();
        this.reason = command.reason();
        this.date = command.date();
        this.patientId = command.patientId();
    }

}
