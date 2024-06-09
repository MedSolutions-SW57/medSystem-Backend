package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.RequestResultResource;

public class RequestResultResourceFromEntityAssembler {
    public static RequestResultResource toResourceFromEntity(Result result) {
        return new RequestResultResource(
                result.getId().toString(),
                result.getDoctorId(),
                result.getPatientId(),
                result.getTypeOfExam(),
                result.getRequestResultDateTime(),
                result.isResult());
    }
}