package com.github.igoraguiar.med.voll.api.domain.Appointment.DTO;

import com.github.igoraguiar.med.voll.api.domain.Appointment.Appointment;

import java.time.LocalDateTime;

public record AppointmentDataDetail(
        Long id,
        Long idDoctor,
        Long idPacient,
        LocalDateTime data) {
    public AppointmentDataDetail(Appointment appointment) {
        this(appointment.getId(), appointment.getDoctorId().getId(), appointment.getPacientId().getId(), appointment.getData());
    }
}
