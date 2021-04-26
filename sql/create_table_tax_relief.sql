create table tax_relief (
id int8 not null default nextval('tax_relief_id_seq'::regclass),
code varchar(5) null,
description varchar(255),
value int8 null,
created_at timestamp default now(),
updated_at timestamp default now(),
constraint tax_relief_pf primary key(id)
);