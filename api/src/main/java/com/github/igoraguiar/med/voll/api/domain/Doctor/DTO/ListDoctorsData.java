package com.github.igoraguiar.med.voll.api.domain.Doctor.DTO;

import com.github.igoraguiar.med.voll.api.domain.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.domain.Doctor.Specialization;

public record ListDoctorsData(Long id,
                              String name,
                              String crm,
                              String email,
                              Specialization specialization) {
    public ListDoctorsData(Doctor data){
        this(data.getId(), data.getName(), data.getCrm(), data.getEmail(), data.getSpecialization());
    }
}
