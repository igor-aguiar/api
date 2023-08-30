create table appointments(
    id bigint primary key auto_increment not null ,
    id_pacient bigint not null ,
    id_doctor bigint not null,
    data datetime not null,


    constraint fk_appointment_doctor_id foreign key (id_doctor) references doctors(id),
    constraint fk_appointment_pacient_id foreign key (id_pacient) references pacients(id)

)