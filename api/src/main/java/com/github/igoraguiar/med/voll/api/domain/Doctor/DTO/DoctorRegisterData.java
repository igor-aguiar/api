package com.github.igoraguiar.med.voll.api.domain.Doctor.DTO;

import com.github.igoraguiar.med.voll.api.domain.Address.DTO.AddressRegisterData;
import com.github.igoraguiar.med.voll.api.domain.Doctor.Specialization;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRegisterData(@NotBlank
                                 String name,
                                 @NotBlank @Email
                                 String email,
                                 @NotBlank @Pattern(regexp = "\\d{4,6}")
                                 String crm,
                                 @NotNull
                                 Specialization specialization,
                                 @NotBlank
                                 String telephone,
                                 @NotNull @Valid
                                 AddressRegisterData address) {
}
