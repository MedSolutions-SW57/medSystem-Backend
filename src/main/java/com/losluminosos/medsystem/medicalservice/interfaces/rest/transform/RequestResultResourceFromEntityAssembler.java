package com.losluminosos.medsystem.medicalservice.interfaces.rest.transform;

import com.losluminosos.medsystem.medicalservice.domain.model.aggregates.Result;
import com.losluminosos.medsystem.medicalservice.interfaces.rest.resources.ResultResource;

public class RequestResultResourceFromEntityAssembler {
    public static ResultResource toResourceFromEntity(Result result) {
        return new ResultResource(
                result.getId().toString(),
                result.getDoctorId(),
                result.getPatientId(),
                result.getTypeOfExam(),
                result.getResultDateTime(),
                result.isResult());
    }
}