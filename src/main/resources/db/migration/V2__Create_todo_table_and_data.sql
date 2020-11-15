create table todos (
    id int NOT NULL AUTO_INCREMENT primary key,
    text varchar(100) not null,
    done BIT
);
insert into todos (text, done) values ('Done todo','1');
insert into todos (text, done) values ('NotDone todo','0');