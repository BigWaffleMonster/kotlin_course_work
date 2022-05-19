CREATE TABLE enroll
(
    id serial primary key,
    policy integer not null,
    year integer not null,
    month integer not null,
    day integer not null,
    time varchar(5) not null,
    doctor_type varchar(255) not null
);