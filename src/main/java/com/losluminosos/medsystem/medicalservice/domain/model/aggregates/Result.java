package com.losluminosos.medsystem.medicalservice.domain.model.aggregates;


import com.losluminosos.medsystem.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Result extends AuditableAbstractAggregateRoot<Result> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id", nullable = false)
    private String doctorId;

    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @Column(name = "type_of_exam", nullable = false)
    private String typeOfExam;

    @Column(name = "request_result_date_time", nullable = false)
    private String requestResultDateTime;

    @Column(name = "result", nullable = false)
    private boolean result;

    public Result(String doctorId, String patientId, String typeOfExam, String requestResultDateTime, boolean result) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.typeOfExam = typeOfExam;
        this.requestResultDateTime = requestResultDateTime;
        this.result = result;
    }

    public Result() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRequestResultDateTime() {
        return requestResultDateTime;
    }

    public void setRequestResultDateTime(String requestResultDateTime) {
        this.requestResultDateTime = requestResultDateTime;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}