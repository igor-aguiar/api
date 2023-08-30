package com.github.igoraguiar.med.voll.api.domain.Appointment;

import com.github.igoraguiar.med.voll.api.domain.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.domain.Pacient.Pacient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Appointment")
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pacient")
    private Pacient pacientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private Doctor doctorId;

    private LocalDateTime data;
}
