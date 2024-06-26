package com.losluminosos.medsystem.medicalservice.domain.model.aggregates;

import com.losluminosos.medsystem.medicalservice.domain.model.commands.CreateTreatmentCommand;
import com.losluminosos.medsystem.medicalservice.domain.model.valueobjects.Period;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Treatment extends AuditableAbstractAggregateRoot<Treatment> {

    @Getter
    @Column(name = "treatment_name")
    private String treatmentName;
    @Getter
    @Column(name = "description")
    private String description;
    @Getter
    @Column(name = "patient_id")
    private Long patientId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="startDate",column=@Column(name = "start_date")),
            @AttributeOverride(name="endDate",column=@Column(name = "end_date"))
    })
    @Getter
    private Period period;

    public Treatment(String treatmentName, String description, String startDate, String endDate) {
        this.treatmentName = treatmentName;
        this.description = description;
        this.period = new Period(startDate, endDate);
    }

    public Treatment(){}

    public Treatment(CreateTreatmentCommand command){
        this();
        this.treatmentName=command.treatmentName();
        this.description=command.description();
        this.patientId=command.patientId();
        this.period=new Period(command.startDate(), command.endDate());
    }

    public String getPeriod(){
        return period.getPeriod();
    }

}
