package com.github.igoraguiar.med.voll.api.domain.Pacient;

import com.github.igoraguiar.med.voll.api.domain.Address.Address;
import com.github.igoraguiar.med.voll.api.domain.Pacient.DTO.PacientUpdateData;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "pacient")
@Table(name = "pacients")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String cpf;
    private boolean active;
    @Embedded
    private Address address;

    public void update(PacientUpdateData data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.telephone() != null){
            this.telephone = data.telephone();
        }
        if (data.address() != null){
            this.address.update(data.address());
        }
    }

    public void deactivate() {
        this.active = false;
    }
}
