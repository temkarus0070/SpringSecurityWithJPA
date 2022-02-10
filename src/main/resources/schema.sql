create table if not exists users
(
    name varchar
(
    255
) primary key ,
    password varchar
(
    255
),
    encryption_type varchar
(
    88
)

    );



create table if not exists authority
(
    authority varchar
(
    255
) primary key
    );

create table if not exists authority_users
(
    name varchar
(
    255
) ,
    authority varchar
(
    255
) ,
    constraint fk_users unique
(
    name,
    authority
)
    );