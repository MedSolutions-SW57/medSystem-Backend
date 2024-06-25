package com.losluminosos.medsystem.profiles.infrastructure.persistence.jpa.repositories;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    Optional<Consultant> findByUserId(Long userId);
}
