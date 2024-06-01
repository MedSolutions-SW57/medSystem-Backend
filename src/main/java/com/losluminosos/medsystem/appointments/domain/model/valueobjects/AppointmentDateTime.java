package com.losluminosos.medsystem.appointments.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AppointmentDateTime(
        String date,
        String time
){
    public AppointmentDateTime() {
        this(null, null);
    }


    public String getDateTime(){
        return String.format("%s %s", date, time);
    }

    public AppointmentDateTime {
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Time cannot be null or empty");
        }
    }

}
