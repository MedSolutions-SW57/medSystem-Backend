package com.losluminosos.medsystem.medicalservice.domain.model.valueobjects;

public record Period(String startDate, String endDate) {
    public Period(){
        this(null, null);
    }

    public String getPeriod(){
        return String.format("From %s to %s", startDate, endDate);
    }

    public Period{
        if (startDate==null || startDate.isBlank())
            throw new IllegalArgumentException("Start date can't be null or empty");
        if (endDate==null || endDate.isBlank())
            throw new IllegalArgumentException("End date can't be null or empty");
    }

}
