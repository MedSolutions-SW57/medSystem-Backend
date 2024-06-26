package com.losluminosos.medsystem.profiles.application.internal.queryservices;

import com.losluminosos.medsystem.profiles.domain.model.aggregates.Consultant;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetAllConsultantsQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetConsultantByIdQuery;
import com.losluminosos.medsystem.profiles.domain.model.queries.GetConsultantByUserIdQuery;
import com.losluminosos.medsystem.profiles.domain.services.ConsultantQueryService;
import com.losluminosos.medsystem.profiles.infrastructure.persistence.jpa.repositories.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultantQueryServiceImpl implements ConsultantQueryService {
    private final ConsultantRepository consultantRepository;

    public ConsultantQueryServiceImpl(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @Override
    public Optional<Consultant> handle(GetConsultantByIdQuery query) {
        return this.consultantRepository.findById(query.id());
    }

    @Override
    public Optional<Consultant> handle(GetConsultantByUserIdQuery query) {
        return this.consultantRepository.findByUserId(query.id());
    }

    @Override
    public List<Consultant> handle(GetAllConsultantsQuery query) {
        return this.consultantRepository.findAll();
    }
}
