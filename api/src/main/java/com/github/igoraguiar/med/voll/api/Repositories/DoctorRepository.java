package com.github.igoraguiar.med.voll.api.Repositories;

import com.github.igoraguiar.med.voll.api.domain.Doctor.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pageable);
}
