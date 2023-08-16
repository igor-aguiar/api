package com.github.igoraguiar.med.voll.api.controller;


import com.github.igoraguiar.med.voll.api.Entity.Address.Address;
import com.github.igoraguiar.med.voll.api.Entity.Pacient.DTO.PacientDetailData;
import com.github.igoraguiar.med.voll.api.Entity.Pacient.DTO.PacientListData;
import com.github.igoraguiar.med.voll.api.Entity.Pacient.DTO.PacientRegisterData;
import com.github.igoraguiar.med.voll.api.Entity.Pacient.DTO.PacientUpdateData;
import com.github.igoraguiar.med.voll.api.Entity.Pacient.Pacient;
import com.github.igoraguiar.med.voll.api.Repositories.PacientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("pacient")
public class PacientController {

    @Autowired
    private PacientRepository pacientRepository;

    @PostMapping
    @Transactional
    ResponseEntity register(@RequestBody @Valid PacientRegisterData data, UriComponentsBuilder uri){
        var pacient = pacientRepository.save(Pacient.builder()
                .name(data.name())
                .cpf(data.cpf())
                .email(data.email())
                .telephone(data.telephone())
                .active(true)
                .address(Address.builder()
                        .street(data.address().street())
                        .zipcode(data.address().zipcode())
                        .city(data.address().city())
                        .complement(data.address().complement())
                        .neighborhood(data.address().neighborhood())
                        .number(data.address().number())
                        .state(data.address().state())
                        .build())
                .build());
        var uriBuild = uri.path("/pacient/{id}").buildAndExpand(pacient.getId()).toUri();

        return ResponseEntity.created(uriBuild).body(new PacientDetailData(pacient));
    }

    @GetMapping
    Page<PacientListData> retrievePacients(Pageable pageable){
        return pacientRepository.findAllByActiveTrue(pageable).map(PacientListData::new);
    }

    @PutMapping
    @Transactional
    ResponseEntity updatePacient(@RequestBody PacientUpdateData data){
        Pacient pacientFound = pacientRepository.getReferenceById(data.id());
        pacientFound.update(data);
        return ResponseEntity.ok(new PacientDetailData(pacientFound));
    }

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity deletePacient(@PathVariable Long id){
        var pacientFound = pacientRepository.getReferenceById(id);
        pacientFound.deactivate();
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    ResponseEntity detailPacient(@PathVariable Long id){
        try{
            var pacientFound = pacientRepository.getReferenceById(id);
            return ResponseEntity.ok(new PacientDetailData(pacientFound));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }




}
