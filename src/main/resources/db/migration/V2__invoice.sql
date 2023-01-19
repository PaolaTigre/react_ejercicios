create table if not exists invoice(
id serial primary key,
code varchar(100) not null unique,
create_at date not null,
total decimal(8,2),
client_id int not null,
foreign key(client_id) references client(id)
);