package com.github.igoraguiar.med.voll.api.controller;

import com.github.igoraguiar.med.voll.api.Entity.Address.Address;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO.DoctorDatailedData;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO.DoctorRegisterData;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO.DoctorUpdateData;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.DTO.ListDoctorsData;
import com.github.igoraguiar.med.voll.api.Entity.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.Repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    Page<ListDoctorsData> retrieveAllDoctor(Pageable pageable){
        return doctorRepository.findAllByActiveTrue(pageable).map(ListDoctorsData::new);
    }

    @PostMapping
    @Transactional
    ResponseEntity registerDoctor(@RequestBody @Valid DoctorRegisterData data, UriComponentsBuilder uriBuilder){
        var createdDoc = doctorRepository.save(Doctor.builder()
                .name(data.name())
                .email(data.email())
                .crm(data.crm())
                .specialization(data.specialization())
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
        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(createdDoc.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDatailedData(createdDoc));
    }

    @PutMapping
    @Transactional
    ResponseEntity updateDoctor(@RequestBody @Valid DoctorUpdateData data){
        var foundedDoctor = doctorRepository.getReferenceById(data.id());
        foundedDoctor.updateData(data);
        return ResponseEntity.ok(new DoctorDatailedData(foundedDoctor));
    }

    @DeleteMapping("/{doctorId}")
    @Transactional
    ResponseEntity deleteDoctor(@PathVariable Long doctorId){
        var doctor = doctorRepository.getReferenceById(doctorId);
        doctor.deactvate();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    ResponseEntity detailDoctor(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDatailedData(doctor));
    }
}
