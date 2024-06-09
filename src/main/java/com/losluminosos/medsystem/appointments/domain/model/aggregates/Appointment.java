package com.losluminosos.medsystem.appointments.domain.model.aggregates;

import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.valueobjects.AppointmentTimePoint;
import com.losluminosos.medsystem.appointments.domain.model.valueobjects.AppointmentReason;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Appointment extends AuditableAbstractAggregateRoot<Appointment> {

    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "patient_id")
    private String patientId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "date")),
            @AttributeOverride(name = "time", column = @Column(name = "time"))
    })
    private AppointmentTimePoint appointmentTimePoint;

    @Embedded
    private AppointmentReason reason;

    public Appointment(String doctorId, String patientId,String reason, String date, String time) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentTimePoint = new AppointmentTimePoint(date, time);
        this.reason = new AppointmentReason(reason);
    }

    public Appointment() {}

    public Appointment(CreateAppointmentCommand command){
        this.doctorId = command.doctorId();
        this.patientId = command.patientId();
        this.appointmentTimePoint = new AppointmentTimePoint(command.date(), command.time());
        this.reason = new AppointmentReason(command.reason());
    }

    public Appointment updateReason(String reason) {
        this.reason = new AppointmentReason(reason);
        return this;

    }

    public String getDoctorId() {
        return doctorId.toString();
    }

    public String getPatientId() {
        return patientId.toString();
    }

    public String getReason() {
        return reason.getReason();
    }

    public String getAppointmentTimePoint() {
        return appointmentTimePoint.getTimePoint();
    }

}
