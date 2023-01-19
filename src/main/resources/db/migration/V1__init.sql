create table if not exists client(
id serial primary key,
nui varchar(10) not null unique,
fullname varchar(50) not null,
address varchar(50) not null
);