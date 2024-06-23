package com.losluminosos.medsystem.profiles.application.internal.commandservices;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Doctor;
import com.losluminosos.medsystem.profiles.domain.model.commands.CreateDoctorCommand;
import com.losluminosos.medsystem.profiles.domain.model.valueobjects.EmailAddress;
import com.losluminosos.medsystem.profiles.domain.services.DoctorCommandService;
import com.losluminosos.medsystem.profiles.infrastructure.persistence.jpa.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorCommandServiceImpl implements DoctorCommandService {
    private final DoctorRepository doctorRepository;

    public DoctorCommandServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<Doctor> handle(CreateDoctorCommand command) {
        var emailAddress = new EmailAddress(command.email());
        if(doctorRepository.existsByEmail(emailAddress))
            throw new IllegalArgumentException("Account with this email already exists.");
        if(doctorRepository.existsByLicenseNumber(command.licenceNumber()))
            throw  new IllegalArgumentException("Account with this licence number already exists.");
        var doctor = new Doctor(command);
        doctorRepository.save(doctor);
        return Optional.of(doctor);
    }
}
