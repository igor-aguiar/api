package com.github.igoraguiar.med.voll.api.Entity.Doctor;

import com.github.igoraguiar.med.voll.api.Entity.Address.Address;
import com.github.igoraguiar.med.voll.api.Entity.Address.DTO.AddressRegisterData;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO.DoctorUpdateData;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Doctor")
@Table(name = "doctors")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    private String telephone;
    @Embedded
    private Address address;
    private boolean active;

    public void updateData(DoctorUpdateData data) {
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

    public void deactvate() {
        this.active = false;
    }
}
