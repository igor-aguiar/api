package com.github.igoraguiar.med.voll.api.domain.Doctor.DTO;

import com.github.igoraguiar.med.voll.api.domain.Address.DTO.AddressRegisterData;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateData(@NotNull
                               Long id,
                               String name,
                               String telephone,
                               AddressRegisterData address) {
}
