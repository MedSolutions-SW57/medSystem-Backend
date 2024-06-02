package com.losluminosos.medsystem.appointments.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AppointmentDateTime(
        String appointmentDate,
        String appointmentTime
){
    public AppointmentDateTime() {
        this(null, null);
    }


    public String getDateTime(){
        return String.format("%s %s", appointmentDate, appointmentTime);
    }

    public AppointmentDateTime {
        if (appointmentDate == null || appointmentDate.isBlank()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if (appointmentTime == null || appointmentTime.isBlank()) {
            throw new IllegalArgumentException("Time cannot be null or empty");
        }
    }

}
