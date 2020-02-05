create table tank(
id bigserial primary key,
name varchar(255) not null,
current_level bigint not null default 0,
capacity bigint not null default 0
);

create table alarm(
id bigserial primary key,
tankId bigint not null,
time timestamp,
current_level  bigint not null default 0,
capacity  bigint not null default 0
);