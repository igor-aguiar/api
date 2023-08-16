package com.github.igoraguiar.med.voll.api.Entity.Pacient.DTO;

import com.github.igoraguiar.med.voll.api.Entity.Address.DTO.AddressRegisterData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacientUpdateData(@NotNull Long id,
                                String name,
                                String telephone,
                                AddressRegisterData address) {
}
