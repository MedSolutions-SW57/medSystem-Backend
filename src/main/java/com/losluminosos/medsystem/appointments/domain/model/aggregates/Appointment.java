package com.losluminosos.medsystem.appointments.domain.model.aggregates;

import com.losluminosos.medsystem.appointments.domain.model.commands.CreateAppointmentCommand;
import com.losluminosos.medsystem.appointments.domain.model.valueobjects.AppointmentDateTime;
import com.losluminosos.medsystem.appointments.domain.model.valueobjects.AppointmentReason;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Appointment extends AuditableAbstractAggregateRoot<Appointment> {


    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "patient_id")
    private String patientId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "appointmentDate", column = @Column(name = "appointment_date")),
            @AttributeOverride(name = "appointmentTime", column = @Column(name = "appointment_time"))
    })
    private AppointmentDateTime appointmentDateTime;

    @Embedded
    private AppointmentReason reason;

    public Appointment(String doctorId, String patientId,String reason, String appointmentDate, String appointmentTime) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDateTime = new AppointmentDateTime(appointmentDate, appointmentTime);
        this.reason = new AppointmentReason(reason);
    }

    public Appointment() {}

    public Appointment(CreateAppointmentCommand command){
        this.doctorId = command.doctorId();
        this.patientId = command.patientId();
        this.appointmentDateTime = new AppointmentDateTime(command.appointmentDate(), command.appointmentTime());
        this.reason = new AppointmentReason(command.reason());
    }

    public void updateReason(String reason) {
        this.reason = new AppointmentReason(reason);
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

    public String getAppointmentDateTime() {
        return appointmentDateTime.getDateTime();
    }
}
