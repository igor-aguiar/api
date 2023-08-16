package com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO;

import com.github.igoraguiar.med.voll.api.Entity.Address.DTO.AddressRegisterData;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateData(@NotNull
                               Long id,
                               String name,
                               String telephone,
                               AddressRegisterData address) {
}
