create table doctors (
                         id bigint not null auto_increment primary key,
                         name varchar(20) not null,
                         email varchar(50) not null unique,
                         crm varchar(6) not null,
                         specialization varchar(20) not null,
                         street varchar(50) not null,
                         neighborhood varchar(20) not null,
                         city varchar(20) not null,
                         state varchar(20) not null,
                         number varchar(20),
                         zipcode varchar(8) not null,
                         complement varchar(50)
)