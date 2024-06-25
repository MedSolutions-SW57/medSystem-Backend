package com.losluminosos.medsystem.laboratoryservice.domain.model.aggregates;

import com.losluminosos.medsystem.laboratoryservice.domain.model.commands.CreateSampleCommand;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Sample extends AuditableAbstractAggregateRoot<Sample> {

    @NotBlank(message = "The sample type cannot be empty")
    String type;

    @NotBlank(message = "The sample code cannot be empty")
    String code;

    @NotNull(message = "The id of patient cannot be empty")
    Long patientId;

    @NotNull(message = "The id of the doctor cannot be empty")
    Long doctorId;

    @NotBlank(message = "The date cannot be empty")
    String date;

    public Sample() {}

    public Sample(String type, String code, Long patientId, Long doctorId, String date) {
        this();
        this.type = type;
        this.code = code;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public Sample(CreateSampleCommand command) {
        this();
        this.type = command.type();
        this.code = command.code();
        this.patientId = command.patientId();
        this.doctorId = command.doctorId();
        this.date = command.date();
    }
}
