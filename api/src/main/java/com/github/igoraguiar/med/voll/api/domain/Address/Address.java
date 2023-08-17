package com.github.igoraguiar.med.voll.api.domain.Address;

import com.github.igoraguiar.med.voll.api.domain.Address.DTO.AddressRegisterData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {

    private String street;
    private String neighborhood;
    private String zipcode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public void update(AddressRegisterData data) {
        if (data.street() != null){
            this.street = data.street();
        }
        if (data.neighborhood() != null){
            this.neighborhood = data.neighborhood();
        }
        if (data.zipcode() != null){
            this.zipcode = data.zipcode();
        }
        if (data.number() != null){
            this.number = data.number();
        }
        if (data.complement() != null){
            this.complement = data.complement();
        }
        if (data.city() != null){
            this.city = data.city();
        }
        if (data.state() != null){
            this.state = data.state();
        }
    }
}
