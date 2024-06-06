package com.losluminosos.medsystem.appointments.interfaces.rest;

import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByDoctorIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsByPatientIdQuery;
import com.losluminosos.medsystem.appointments.domain.model.queries.GetAllAppointmentsQuery;
import com.losluminosos.medsystem.appointments.domain.services.AppointmentCommandService;
import com.losluminosos.medsystem.appointments.domain.services.AppointmentQueryService;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.AppointmentResource;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.CreateAppointmentResource;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.DeleteAppointmentResource;
import com.losluminosos.medsystem.appointments.interfaces.rest.resources.UpdateAppointmentReasonResource;
import com.losluminosos.medsystem.appointments.interfaces.rest.transform.AppointmentResourceFromEntityAssembler;
import com.losluminosos.medsystem.appointments.interfaces.rest.transform.CreateAppointmentCommandFromResourceAssembler;
import com.losluminosos.medsystem.appointments.interfaces.rest.transform.DeleteAppointmentCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Appointments", description = "Appointment Management Endpoints")
public class AppointmentsController {
    private final AppointmentCommandService appointmentCommandService;
    private final AppointmentQueryService appointmentQueryService;

    public AppointmentsController(AppointmentCommandService appointmentCommandService, AppointmentQueryService appointmentQueryService){
        this.appointmentCommandService = appointmentCommandService;
        this.appointmentQueryService = appointmentQueryService;
    }

    @PostMapping
    public ResponseEntity<AppointmentResource> createAppointment(@RequestBody CreateAppointmentResource resource) {
        var createAppointmentCommand = CreateAppointmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var appointment = appointmentCommandService.handle(createAppointmentCommand);
        if (appointment.isEmpty()) return ResponseEntity.badRequest().build();
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(appointment.get());
        return new ResponseEntity<>(appointmentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<AppointmentResource> getAppointmentByPatientId(@PathVariable Long patientId) {
        var getAppointmentByPatientIdQuery = new GetAllAppointmentsByPatientIdQuery(patientId);
        var appointment = appointmentQueryService.handle(getAppointmentByPatientIdQuery);
        if (appointment.isEmpty()) return ResponseEntity.badRequest().build();
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(appointment.get());
        return ResponseEntity.ok(appointmentResource);

    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<AppointmentResource> getAppointmentByDoctorId(@PathVariable Long doctorId) {
        var getAppointmentByDoctorIdQuery = new GetAllAppointmentsByDoctorIdQuery(doctorId);
        var appointment = appointmentQueryService.handle(getAppointmentByDoctorIdQuery);
        if (appointment.isEmpty()) return ResponseEntity.badRequest().build();
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(appointment.get());
        return ResponseEntity.ok(appointmentResource);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResource>> getAllAppointments(){
        var getAllAppointmentsQuery = new GetAllAppointmentsQuery();
        var appointments = appointmentQueryService.handle(getAllAppointmentsQuery);
        var appointmentResources = appointments.stream()
                .map(AppointmentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(appointmentResources);
    }
    /*
    @PutMapping ResponseEntity<AppointmentResource> updateAppointmentReason(@RequestBody UpdateAppointmentReasonResource resource) {
        var updateAppointmentReasonCommand = CreateAppointmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var appointment = appointmentCommandService.handle(createAppointmentCommand);
        if (appointment.isEmpty()) return ResponseEntity.badRequest().build();
        var appointmentResource = AppointmentResourceFromEntityAssembler.toResourceFromEntity(appointment.get());
        return ResponseEntity.ok(appointmentResource);
    }

     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        var deleteAppointmentResource = new DeleteAppointmentResource(id);
        var deleteAppointmentCommand = DeleteAppointmentCommandFromResourceAssembler.toCommandFromResource(deleteAppointmentResource);
        appointmentCommandService.handle(deleteAppointmentCommand);
        return ResponseEntity.noContent().build();
    }
}
