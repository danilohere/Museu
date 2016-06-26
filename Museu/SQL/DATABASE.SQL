create database museu;

use museu;

CREATE TABLE obra (
	id int primary key auto_increment,
	nome varchar(50),
	autor varchar(50),
	descricao varchar(500),
	categoria varchar(30),
	material varchar(50),
	dimensoes varchar(20),
	ano int,
	imagem varchar(200));
	
CREATE TABLE autor (
	id int primary key auto_increment,
	nome varchar(50),
	nasc date,
	periodo varchar(20),
	biografia varchar(200));
	
CREATE TABLE evento (
	id int primary key auto_increment,
	nome varchar(30),
	datainicio date,
	dataterm date,
	valortot float,
	valormeia float,
	qnting int
	
	);