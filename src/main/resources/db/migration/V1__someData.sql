create table languages (
    id int NOT NULL AUTO_INCREMENT primary key,
    welcomeMsg varchar(100) not null,
    code varchar(3)
);
insert into languages (welcomeMsg, code) values ('Hello','en');
insert into languages (welcomeMsg, code) values ('Siemanko','pl');
insert into languages (welcomeMsg, code) values ('Halo','de');