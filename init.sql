create table person
(
    id         bigint generated by default as identity,
    age        integer,
    first_name varchar(255),
    last_name  varchar(255),

    primary key (id)
);


insert into person (age, first_name, last_name)
values  (18,'John','Lobovsky'),
        (24,'Sergey','Sergeev'),
        (25,'Ivan', 'Ivanov'),
        (20,'Michail', 'Michailov'),
        (17, 'Masha', 'Tutina')
        (19, 'Grisha', 'Ivlev')
;

