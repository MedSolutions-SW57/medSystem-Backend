package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.entities.Report;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.ReportResource;

public class ReportResourceFromEntityAssembler {
    public static ReportResource toResourceFromEntity(Report entity){
        return new ReportResource(entity.getId(), entity.getReason(), entity.getDate(), entity.getPatientId());
    }
}
