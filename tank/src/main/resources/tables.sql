create table tank(
id bigserial primary key,
name varchar(255) not null,
current_level bigint not null default 0,
capacity bigint not null default 0
);

