CREATE TABLE groups (
idGroup serial primary key,
groupName varchar(10)
);

CREATE TABLE users (
idUser serial primary key,
username varchar(10),
password varchar(10),
idGroupFK int,
FOREIGN KEY (idGroupFK) REFERENCES groups(idGroup) 
);


insert into groups values (1, 'admin');
insert into groups values (2, 'user');


insert into users values (1, 'teste', 'pass', 1);
