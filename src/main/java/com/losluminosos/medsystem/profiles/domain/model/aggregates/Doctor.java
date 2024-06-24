package com.losluminosos.medsystem.profiles.domain.model.aggregates;

import com.losluminosos.medsystem.profiles.domain.model.commands.CreateDoctorCommand;
import com.losluminosos.medsystem.profiles.domain.model.valueobjects.EmailAddress;
import com.losluminosos.medsystem.profiles.domain.model.valueobjects.PersonName;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
public class Doctor extends AuditableAbstractAggregateRoot<Doctor> {

    private String specialty;

    @Size(max = 7)
    private String licenseNumber;

    private Long userId;

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    @Size(max = 9)
    private String phone;

    public Doctor(){}

    public Doctor(CreateDoctorCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.phone = command.phone();
        this.specialty = command.specialty();
        this.licenseNumber = command.licenceNumber();
        this.userId = command.userId();
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }}
