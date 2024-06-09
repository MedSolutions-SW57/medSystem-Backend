package com.losluminosos.medsystem.appointments.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AppointmentTimePoint(
        String date,
        String time
){
    public AppointmentTimePoint() {
        this(null, null);
    }


    public String getTimePoint(){
        return String.format("%s %s", date, time);
    }

    public AppointmentTimePoint {
        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Time cannot be null or empty");
        }
    }

}
