package com.github.igoraguiar.med.voll.api.Entity.Address.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRegisterData(@NotBlank
                                  String street,
                                  @NotBlank
                                  String neighborhood,
                                  @NotBlank @Pattern(regexp = "\\d{8}")
                                  String zipcode,
                                  @NotBlank
                                  String city,
                                  @NotBlank
                                  String state,
                                  String number,
                                  String complement) {
}
