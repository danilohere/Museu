create database museu;

use museu;

CREATE TABLE obra (
	id int primary key auto_increment,
	nome varchar(50),
	autor varchar(50),
	descricao varchar(500)
	categoria varchar(30),
	material varchar(50),
	dimensoes varchar(20),
	ano int);