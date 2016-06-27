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
	biografia varchar(200),
	imagem longblob);
	
	INSERT INTO autor VALUES (null, 'Autor1', '01/03/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum', null);
	INSERT INTO autor VALUES (null, 'Autor2', '01/03/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum', null);
	INSERT INTO autor VALUES (null, 'Autor3', '01/03/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum', null);
	INSERT INTO autor VALUES (null, 'Autor4', '01/03/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum', null);
	INSERT INTO autor VALUES (null, 'Autor5', '01/03/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum', null);
	
CREATE TABLE evento (
	id int primary key auto_increment,
	nome varchar(30),
	descricao varchar(200),
	datainicio date,
	dataenc date,
	valortot float,
	valormeia float,
	qnting int);
	
	INSERT INTO evento VALUES (null, 'Evento1', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
	INSERT INTO evento VALUES (null, 'Evento2', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
	INSERT INTO evento VALUES (null, 'Evento3', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
	INSERT INTO evento VALUES (null, 'Evento4', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
	INSERT INTO evento VALUES (null, 'Evento5', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');