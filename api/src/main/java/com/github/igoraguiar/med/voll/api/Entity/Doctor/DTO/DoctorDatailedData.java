package com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO;

import com.github.igoraguiar.med.voll.api.Entity.Address.Address;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.Specialization;

public record DoctorDatailedData(Long id, String name, String email, String crm, String telephone, Specialization specialization, Address address) {
    public DoctorDatailedData(Doctor data){
        this(data.getId(), data.getName(),data.getEmail(), data.getCrm(), data.getTelephone(), data.getSpecialization(), data.getAddress());
    }
}
