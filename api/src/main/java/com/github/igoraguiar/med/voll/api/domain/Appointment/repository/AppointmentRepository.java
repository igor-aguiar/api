package com.github.igoraguiar.med.voll.api.domain.Appointment.repository;

import com.github.igoraguiar.med.voll.api.domain.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
