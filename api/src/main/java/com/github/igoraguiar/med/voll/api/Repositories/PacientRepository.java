package com.github.igoraguiar.med.voll.api.Repositories;

import com.github.igoraguiar.med.voll.api.Entity.Pacient.Pacient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {
    Page<Pacient> findAllByActiveTrue(Pageable pageable);
}
