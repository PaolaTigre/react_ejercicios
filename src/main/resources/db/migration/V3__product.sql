create table if not exists product(
id serial primary key,
description varchar(100) not null,
brand varchar(100) not null,
stock int not null
);
create table if not exists detail(
id serial primary key,
quantity int not null,
invoice_id int not null,
product_id int not null,
foreign key(invoice_id) references invoice(id),
foreign key(product_id) references product(id)
);