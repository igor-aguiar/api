package com.github.igoraguiar.med.voll.api.domain.Pacient.DTO;

import com.github.igoraguiar.med.voll.api.domain.Address.DTO.AddressRegisterData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacientRegisterData(@NotBlank
                                  String name,
                                  @NotBlank
                                  String email,
                                  @NotBlank
                                  String telephone,
                                  @NotBlank
                                  String cpf,
                                  @NotNull @Valid
                                  AddressRegisterData address) {
}
