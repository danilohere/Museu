create database museu;

use museu;

CREATE SEQUENCE sq_obra
  NOCYCLE
  MINVALUE 1
  INCREMENT BY 1;

CREATE TABLE obra (
	id int primary key,
	nome varchar(50),
	autor varchar(50),
	descricao varchar(500),
	categoria varchar(30),
	material varchar(50),
	dimensoes varchar(20),
	ano int,
	imagem varchar(255));
	
INSERT INTO obra VALUES (sq_obra.NEXTVAL, 'Obra1', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', 'C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\Obras\\mona-lisa.jpg');
INSERT INTO obra VALUES (sq_obra.NEXTVAL, 'Obra2', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', 'C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\Obras\\mona-lisa.jpg');
INSERT INTO obra VALUES (sq_obra.NEXTVAL, 'Obra3', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', 'C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\Obras\\mona-lisa.jpg');
INSERT INTO obra VALUES (sq_obra.NEXTVAL, 'Obra4', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', 'C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\Obras\\mona-lisa.jpg');
INSERT INTO obra VALUES (sq_obra.NEXTVAL, 'Obra5', 'Autor1', 'Descrição', 'Categoria', 'Material1', '15 cm x 15 cm', '2016', 'C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\Obras\\mona-lisa.jpg');

CREATE SEQUENCE sq_autor
  NOCYCLE
  MINVALUE 1
  INCREMENT BY 1;
  
DROP TABLE autor;
CREATE TABLE autor (
	id int primary key,
	nome varchar(50),
	nasc varchar(10),
	periodo varchar(20),
	biografia varchar(200));
	
INSERT INTO autor VALUES (sq_autor.NEXTVAL, 'Autor1', '01/01/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum');
INSERT INTO autor VALUES (sq_autor.NEXTVAL, 'Autor2', '01/01/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum');
INSERT INTO autor VALUES (sq_autor.NEXTVAL, 'Autor3', '01/01/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum');
INSERT INTO autor VALUES (sq_autor.NEXTVAL, 'Autor4', '01/01/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum');
INSERT INTO autor VALUES (sq_autor.NEXTVAL, 'Autor5', '01/01/1600', 'Barroco', 'Um artista desconhecido por conta de seu nome nada comum');
	
  
CREATE SEQUENCE sq_evento
  NOCYCLE
  MINVALUE 1
  INCREMENT BY 1;
  

drop table evento;

CREATE TABLE evento (
	id int primary key,
	nome varchar(30),
	descricao varchar(200),
	datainicio varchar(10),
	dataenc varchar(10),
	valortot number,
	valormeia number,
	qnting int);
	
INSERT INTO evento VALUES (sq_evento.NEXTVAL, 'Evento1', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
INSERT INTO evento VALUES (sq_evento.NEXTVAL, 'Evento2', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
INSERT INTO evento VALUES (sq_evento.NEXTVAL, 'Evento3', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
INSERT INTO evento VALUES (sq_evento.NEXTVAL, 'Evento4', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
INSERT INTO evento VALUES (sq_evento.NEXTVAL, 'Evento5', 'Descrição', '01/03/2016', '10/03/2016', '50,00', '25,00', '200');
	
CREATE TABLE login (
	usuario varchar(30) primary key,
	senha varchar(30));
	
INSERT INTO login VALUES ('admin', '123');

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE ProcRelatorio (out_result OUT VARCHAR) AS
retorno1 number;
retorno2 number;
retorno3 number;
BEGIN
  SELECT COUNT (*) INTO retorno1 FROM obra;
  SELECT COUNT (*) INTO retorno2 FROM autor;
  SELECT COUNT (*) INTO retorno3 FROM evento;
  out_result := 
  'Quantidade de obras: '||retorno1|| CHR(13) ||
  ' | Quantidade de autores: '||retorno2|| CHR(13) ||
  ' | Quantidade de eventos: '||retorno3; 
END;

EXEC ProcRelatorio(Types.VARCHAR);