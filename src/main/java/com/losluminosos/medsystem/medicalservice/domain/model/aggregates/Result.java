package com.losluminosos.medsystem.medicalservice.domain.model.aggregates;


import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Result extends AuditableAbstractAggregateRoot<Result> {
    @NotNull
    private String doctorId;

    @NotNull
    private String patientId;

    @NotNull
    private String typeOfExam;

    @NotNull
    private String resultDateTime;

    @NotNull
    private boolean result;

    public Result(String doctorId, String patientId, String typeOfExam, String resultDateTime, boolean result) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.typeOfExam = typeOfExam;
        this.resultDateTime = resultDateTime;
        this.result = result;
    }

    public Result() {
    }

    // Getters y setters

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getTypeOfExam() {
        return typeOfExam;
    }

    public void setTypeOfExam(String typeOfExam) {
        this.typeOfExam = typeOfExam;
    }

    public String getResultDateTime() {
        return resultDateTime;
    }

    public void setResultDateTime(String resultDateTime) {
        this.resultDateTime = resultDateTime;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}