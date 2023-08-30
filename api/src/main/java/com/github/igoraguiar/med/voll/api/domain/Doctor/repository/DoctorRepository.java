package com.github.igoraguiar.med.voll.api.domain.Doctor.repository;

import com.github.igoraguiar.med.voll.api.domain.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.domain.Doctor.Specialization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pageable);

    @Query("""
            select d from Doctor d 
            where d.active = true
            and d.specialization = :specialization 
            and d.id not in (
                select a.doctorId.id 
                from Appointment a 
                where a.data = :appointmentDate
            )
            order by rand()
            limit 1
            """)
    Doctor findAvaiableDoctor(LocalDateTime appointmentDate, Specialization specialization);
}
