package com.losluminosos.medsystem.medicalservice.domain.model.aggregates;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateHistoryCommand;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class History extends AuditableAbstractAggregateRoot<History> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "date", nullable = false, updatable = false)
    private String date;

    @Column(name = "patient_id", nullable = false, updatable = false)
    @Getter
    private String patientId;

    @Column(name = "doctor_id", nullable = false, updatable = false)
    @Getter
    private String doctorId;

    protected History(){}


    public History(String reason, String date) {
        reason = reason;
        date = date;
    }

    public History(CreateHistoryCommand command){
        this();
        this.reason = command.reason();
        this.date = command.date();
        this.patientId = command.patientId();
        this.doctorId = command.doctorId();
    }


}
