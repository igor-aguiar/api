package com.github.igoraguiar.med.voll.api.controller;

import com.github.igoraguiar.med.voll.api.domain.Appointment.DTO.AppointmentData;
import com.github.igoraguiar.med.voll.api.domain.Appointment.DTO.AppointmentDataDetail;
import com.github.igoraguiar.med.voll.api.domain.Appointment.DTO.CancellationReasonData;
import com.github.igoraguiar.med.voll.api.domain.Appointment.ScheduleAppointment;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    private ScheduleAppointment scheduleAppointment;

    @PostMapping
    @Transactional
    public ResponseEntity newAppointment(@RequestBody @Valid AppointmentData data){
        var appointment = scheduleAppointment.createAppointment(data);
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteAppointment(@RequestBody @Valid CancellationReasonData data ){
        scheduleAppointment.delete(data);
        return ResponseEntity.noContent().build();
    }
}
