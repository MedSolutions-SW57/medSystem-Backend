package com.losluminosos.medsystem.appointments.domain.model.valueobjects;

public record AppointmentReason(String reason) {
    public AppointmentReason() {
        this(null);
    }

    public String getReason() {
        return reason;
    }

    public AppointmentReason {
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Reason cannot be null");
        }
    }
}
