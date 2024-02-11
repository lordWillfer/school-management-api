create table users
(
    id       bigint not null,
    login    varchar(255) unique,
    password varchar(255),
    primary key (id)
);