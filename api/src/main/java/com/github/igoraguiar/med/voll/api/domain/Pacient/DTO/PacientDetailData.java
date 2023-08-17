package com.github.igoraguiar.med.voll.api.domain.Pacient.DTO;

import com.github.igoraguiar.med.voll.api.domain.Pacient.Pacient;

public record PacientDetailData(Long id, String name, String cpf, String telephone, String email) {

    public PacientDetailData(Pacient data){
        this(data.getId(), data.getName(), data.getCpf(), data.getTelephone(), data.getEmail());
    }
}
