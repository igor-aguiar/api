package com.github.igoraguiar.med.voll.api.Entity.Pacient.DTO;

import com.github.igoraguiar.med.voll.api.Entity.Pacient.Pacient;

public record PacientListData(String name,
                              String email,
                              String cpf) {

    public PacientListData(Pacient data){
        this(data.getName(), data.getEmail(), data.getCpf());
    }
}
