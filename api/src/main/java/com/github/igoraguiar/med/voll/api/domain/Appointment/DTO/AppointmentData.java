package com.github.igoraguiar.med.voll.api.domain.Appointment.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.github.igoraguiar.med.voll.api.domain.Doctor.Specialization;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentData(
        @JsonAlias("id_doctor")
        Long idDoctor,
        @NotNull
        @JsonAlias("id_pacient")
        Long idPacient,
        @NotNull
        @Future
        LocalDateTime date,
        Specialization specialization) {
}
