package com.github.igoraguiar.med.voll.api.domain.Appointment.DTO;

import jakarta.validation.constraints.NotNull;

public record CancellationReasonData(
        @NotNull
        Long id,
        @NotNull
        CancellationReason reason) {
}
