package com.github.igoraguiar.med.voll.api.domain.Appointment;

import com.github.igoraguiar.med.voll.api.domain.Appointment.DTO.AppointmentData;
import com.github.igoraguiar.med.voll.api.domain.Appointment.DTO.AppointmentDataDetail;
import com.github.igoraguiar.med.voll.api.domain.Appointment.DTO.CancellationReasonData;
import com.github.igoraguiar.med.voll.api.domain.Appointment.repository.AppointmentRepository;
import com.github.igoraguiar.med.voll.api.domain.Doctor.Doctor;
import com.github.igoraguiar.med.voll.api.domain.Doctor.repository.DoctorRepository;
import com.github.igoraguiar.med.voll.api.domain.Pacient.repository.PacientRepository;
import com.github.igoraguiar.med.voll.api.domain.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleAppointment {

    @Autowired
    private AppointmentRepository repository;
    @Autowired
    private PacientRepository pacientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public AppointmentDataDetail createAppointment(AppointmentData data) {
        if (!pacientRepository.existsById(data.idPacient())){
            throw new ValidationException("Pacient ID does not exist");
        }
        if (data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())){
            throw new ValidationException("Doctor ID does not exist");
        }

        var pacient = pacientRepository.getReferenceById(data.idPacient());
        var appointmentDate = data.date();
        var doctor = selectDoctor(data);

        return new AppointmentDataDetail(repository.save(new Appointment(null, pacient, doctor, appointmentDate, null)));
    }

    private Doctor selectDoctor(AppointmentData data) {
        if (data.idDoctor() != null){
            return doctorRepository.getReferenceById(data.idDoctor());
        }
        if (data.specialization() == null){
            throw new ValidationException("Specialization is mandatory when a doctor isn't selected");
        }

        return doctorRepository.findAvaiableDoctor(data.date(), data.specialization());
    }

    public void delete(CancellationReasonData data) {
        if (!repository.existsById(data.id())){
            throw new ValidationException("There isn't an appointment with this ID");
        }
        var appointment = repository.getReferenceById(data.id());
        appointment.cancel(data.reason());

    }
}
