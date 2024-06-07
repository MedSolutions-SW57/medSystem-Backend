package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.RequestResult;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.RequestResultResource;

public class RequestResultResourceFromEntityAssembler {
    public static RequestResultResource toResourceFromEntity(RequestResult requestResult) {
        return new RequestResultResource(
                requestResult.getId().toString(),
                requestResult.getDoctorId(),
                requestResult.getPatientId(),
                requestResult.getTypeOfExam(),
                requestResult.getRequestResultDateTime(),
                requestResult.isResult());
    }
}