package com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO;

import com.github.igoraguiar.med.voll.api.Entity.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.Specialization;

public record ListDoctorsData(Long id,
                              String name,
                              String crm,
                              String email,
                              Specialization specialization) {
    public ListDoctorsData(Doctor data){
        this(data.getId(), data.getName(), data.getCrm(), data.getEmail(), data.getSpecialization());
    }
}
