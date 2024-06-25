package com.losluminosos.medsystem.profiles.domain.model.aggregates;

import com.losluminosos.medsystem.profiles.domain.model.commands.CreateConsultantCommand;
import com.losluminosos.medsystem.profiles.domain.model.valueobjects.EmailAddress;
import com.losluminosos.medsystem.profiles.domain.model.valueobjects.PersonName;
import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Consultant extends AuditableAbstractAggregateRoot<Consultant> {
    private String licenseNumber;

    private Long userId;

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    private String phone;

    public Consultant(){}

    public Consultant(CreateConsultantCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.phone = command.phone();
        this.licenseNumber = command.licenceNumber();
        this.userId = command.userId();
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }
}
