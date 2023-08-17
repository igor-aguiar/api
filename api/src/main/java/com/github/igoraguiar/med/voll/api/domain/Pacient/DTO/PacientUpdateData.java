package com.github.igoraguiar.med.voll.api.domain.Pacient.DTO;

import com.github.igoraguiar.med.voll.api.domain.Address.DTO.AddressRegisterData;
import jakarta.validation.constraints.NotNull;

public record PacientUpdateData(@NotNull Long id,
                                String name,
                                String telephone,
                                AddressRegisterData address) {
}
