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
	imagem longblob);
	
	INSERT INTO obra VALUES (null, 'Obra1', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra2', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra3', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra4', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra5', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra6', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra7', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra8', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra9', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	INSERT INTO obra VALUES (null, 'Obra10', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', null);
	
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