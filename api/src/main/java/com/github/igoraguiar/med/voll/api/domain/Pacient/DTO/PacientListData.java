package com.github.igoraguiar.med.voll.api.domain.Pacient.DTO;

import com.github.igoraguiar.med.voll.api.domain.Pacient.Pacient;

public record PacientListData(String name,
                              String email,
                              String cpf) {

    public PacientListData(Pacient data){
        this(data.getName(), data.getEmail(), data.getCpf());
    }
}
