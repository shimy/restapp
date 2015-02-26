create database restappdb;

create table restappdb.book (
	id int(11) not null auto_increment,
    title varchar(64),
    author varchar(64),
    description varchar(256),
    price int(11),
    createAt timestamp,
    updateAt timestamp,
    primary key (id)
);

