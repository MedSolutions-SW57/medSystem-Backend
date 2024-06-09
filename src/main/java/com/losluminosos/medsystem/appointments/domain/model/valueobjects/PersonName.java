package com.losluminosos.medsystem.appointments.domain.model.valueobjects;

public record PersonName(String firstName, String lastName) {

    public PersonName(){
        this(null, null);
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }

    public PersonName {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be null or empty");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or empty");
    }
}
