package com.github.igoraguiar.med.voll.api.domain.Pacient.repository;

import com.github.igoraguiar.med.voll.api.domain.Pacient.Pacient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {
    Page<Pacient> findAllByActiveTrue(Pageable pageable);
}
