package com.losluminosos.medsystem.laboratoryservice.domain.model.entities;

import com.losluminosos.medsystem.laboratoryservice.domain.model.valueobjects.Status;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class AnalysisStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public AnalysisStatus() {
    }

    public AnalysisStatus(Status status){
        this();
        this.status = status;
    }
}
